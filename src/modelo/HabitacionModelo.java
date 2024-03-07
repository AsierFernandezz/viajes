package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import controlador.Conector;

public class HabitacionModelo extends Conector{
	
	HotelModelo hom = new HotelModelo();
	
	public boolean insertarHabitacion(Hotel hotel, Habitacion habitacion) {
		String sql = "INSERT INTO habitaciones (id_hotel,numero,descripcion,precio) VALUES (?,?,?,?)";
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, hotel.getId());
			pst.setInt(2, habitacion.getNumero());
			pst.setString(3, habitacion.getDescripcion());
			pst.setDouble(4, habitacion.getPrecio());
			
			pst.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}	
	}
	public ArrayList<Habitacion> buscarHabitaciones(Hotel hotel){
		String sql = "SELECT * FROM habitaciones WHERE id_hotel=?";
		ArrayList<Habitacion> habitaciones = new ArrayList<>();
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, hotel.getId());
			ResultSet rs = pst.executeQuery();
			
			while (rs.next()) {
				Habitacion h = new Habitacion();
				
				h.setId(rs.getInt("id"));
				h.setId_hotel(hom.getHotel(rs.getInt("id_hotel")));
				h.setNumero(rs.getInt("numero"));
				h.setDescripcion(rs.getString("descripcion"));
				h.setPrecio(rs.getInt("precio"));
				
				habitaciones.add(h);
			}
		} catch (SQLException e) {
			System.out.println("Error buscarhabitaciones");
			e.printStackTrace();
		}
		return habitaciones;
	}
	
	public Habitacion getHabitacion(Hotel hotel,int numero){
		String sql = "SELECT * FROM habitaciones WHERE id_hotel=? AND numero=?";
		Habitacion h = new Habitacion();
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, hotel.getId());
			pst.setInt(2, numero);
			buscarHabitacionenBD(h, pst);
				
		} catch (SQLException e) {
			System.out.println("Error buscarhabitaciones");
			e.printStackTrace();
		}
		return h;
	}
	private void buscarHabitacionenBD(Habitacion h, PreparedStatement pst) throws SQLException {
		ResultSet rs = pst.executeQuery();
		rs.next();
		
		h.setId(rs.getInt("id"));
		h.setId_hotel(hom.getHotel(rs.getInt("id_hotel")));
		h.setNumero(rs.getInt("numero"));
		h.setDescripcion(rs.getString("descripcion"));
		h.setPrecio(rs.getInt("precio"));
	}
	public Habitacion getHabitacion(int id){
		String sql = "SELECT * FROM habitaciones WHERE id=?";
		Habitacion h = new Habitacion();
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, id);
			
			buscarHabitacionenBD(h, pst);
				
		} catch (SQLException e) {
			System.out.println("Error buscarhabitaciones");
			e.printStackTrace();
		}
		return h;
	}
	
	public void eliminarHabitacion(int idHabitacion) {
		
		String sql = "DELETE FROM habitaciones WHERE id = ?";
		
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, idHabitacion);
			
			pst.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
