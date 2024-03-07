package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import controlador.Conector;

public class HotelModelo extends Conector{
	
	public boolean insertarHotel(Hotel h) {
		String sql = "INSERT INTO hoteles (cif,nombre,gerente,estrellas,compania) VALUES (?,?,?,?,?)";
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, h.getCif());
			pst.setString(2, h.getNombre());
			pst.setString(3, h.getGerente());
			pst.setInt(4, h.getEstrellas());
			pst.setString(5, h.getCompania());
			 pst.execute();
			 
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public Hotel getHotel(String nombre) {
		String sql = "SELECT * FROM hoteles WHERE nombre=?";
		Hotel h = new Hotel();
		
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, nombre);
			
			buscarHotelenBD(h, pst);
			
		} catch (SQLException e) {
			System.out.println("Error en buscarHotel");
			e.printStackTrace();
		}
		return h;
	}
	public Hotel getHotel(int id) {
		String sql = "SELECT * FROM hoteles WHERE id=?";
		Hotel h = new Hotel();
		
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, id);
			
			buscarHotelenBD(h, pst);
			
		} catch (SQLException e) {
			System.out.println("Error en buscarHotel");
			e.printStackTrace();
		}
		return h;
	}
	private void buscarHotelenBD(Hotel h, PreparedStatement pst) throws SQLException {
		ResultSet rs = pst.executeQuery();
		rs.next();
		
		h.setId(rs.getInt("id"));
		h.setCif(rs.getString("cif"));
		h.setNombre(rs.getString("nombre"));
		h.setEstrellas(rs.getInt("estrellas"));
		h.setGerente(rs.getString("gerente"));
		h.setCompania(rs.getString("compania"));
	}
	
	public ArrayList<Hotel> visualizarHoteles(){
		String sql = "SELECT * FROM hoteles";
		ArrayList<Hotel> hoteles = new ArrayList<>();
		
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			while (rs.next()){
				Hotel h = new Hotel();
			
				h.setId(rs.getInt("id"));
				h.setCif(rs.getString("cif"));
				h.setNombre(rs.getString("nombre"));
				h.setGerente(rs.getString("gerente"));
				h.setEstrellas(rs.getInt("estrellas"));
				h.setCompania(rs.getString("compania"));
				
				hoteles.add(h);
			}
		} catch (SQLException e) {
			System.out.println("Error VisuHoteles");
			e.printStackTrace();
		}
	return hoteles;	
	}
	
	public boolean borrarHotel(Hotel h) {
		String sql = "DELETE FROM hoteles WHERE id=?";
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, h.getId());
			
			pst.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	public boolean modHotel(int id,Hotel h) {
		String sql = "UPDATE hoteles SET cif=?,nombre=?,gerente=?,estrellas=?,compania=? WHERE id=?";
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, h.getCif());
			pst.setString(2, h.getNombre());
			pst.setString(3, h.getGerente());
			pst.setInt(4, h.getEstrellas());
			pst.setString(5, h.getCompania());
			pst.setInt(6, id);
			
			pst.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
}
