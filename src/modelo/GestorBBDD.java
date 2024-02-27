package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import controlador.Conector;


public class GestorBBDD extends Conector{

	public ArrayList<Cliente> VerTodosClientes() {

		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		String sql = "SELECT * FROM clientes";
		
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				Cliente cliente = new Cliente();
				cliente.setDni(rs.getString("dni"));
				cliente.setNombre(rs.getString("nombre"));
				cliente.setApellidos(rs.getString("apellidos"));
				cliente.setDireccion(rs.getString("direccion"));
				cliente.setLocalidad(rs.getString("localidad"));
				
				clientes.add(cliente);
			}
			
			return clientes;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
		
		
	}
	
	public void insertarCliente(Cliente cliente) {
		
		String sql = "INSERT INTO clientes (dni,nombre,apellidos,direccion,localidad) VALUES (?,?,?,?,?)";
		
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, cliente.getDni());
			pst.setString(2, cliente.getNombre());
			pst.setString(3, cliente.getApellidos());
			pst.setString(4, cliente.getDireccion());
			pst.setString(5, cliente.getLocalidad());
			
			pst.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public ArrayList<Habitacion> getHotel(int id_hotel) {
		
		ArrayList<Habitacion> habitaciones = new ArrayList<Habitacion>();
		String sql = "SELECT * FROM habitaciones WHERE id_hotel = ?";
		
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, id_hotel);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
			Habitacion habitacion = new Habitacion();
			habitacion.setId(rs.getInt("id"));
			habitacion.setId_hotel(rs.getInt("id_hotel"));
			habitacion.setNumero(rs.getString("numero"));
			habitacion.setDescripcion(rs.getString("descripcion"));
			habitacion.setPrecio(rs.getDouble("precio"));
			
			habitaciones.add(habitacion);
			}
			
			return habitaciones;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return null;
		
	}
	
}
