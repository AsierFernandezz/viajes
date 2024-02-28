package modelo;

import java.sql.Date;
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
	
	public void realizarReserva(Reserva reserva) {
		
		String sql = "INSERT INTO reservas (id_habitacion,dni,desde,hasta) VALUES (?,?,?,?)";
		
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, reserva.gethabitacion().getId());
			pst.setString(2, reserva.getCliente().getDni());
			pst.setDate(3, new java.sql.Date(reserva.getDesde().getTime()));
			pst.setDate(4, new java.sql.Date(reserva.getHasta().getTime()));
			
			pst.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ArrayList<Habitacion> getHotel(Hotel hotel) {
		
		ArrayList<Habitacion> habitaciones = new ArrayList<Habitacion>();
		String sql = "SELECT * FROM habitaciones WHERE id_hotel = ?";
		
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, hotel.getId());
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
	
	public Hotel getIdHotelXNombre(String nombre_hotel) {
		
		String sql = "SELECT * FROM hoteles WHERE nombre = ?";
		
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, nombre_hotel);
			ResultSet rs = pst.executeQuery();
			
			rs.next();
			Hotel hotel = new Hotel();
			hotel.setId(rs.getInt("id")); 
			
			return hotel;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return null;
		
	}
	
	public Cliente getClienteXDni(String dniCliente) {
		
		String sql = "SELECT * FROM clientes WHERE dni = ?";
		
		PreparedStatement pst;
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, dniCliente);
			ResultSet rs = pst.executeQuery();
			
			rs.next();
			Cliente cliente = new Cliente();
			cliente.setDni(rs.getString("dni"));
			cliente.setNombre(rs.getString("nombre"));
			cliente.setApellidos(rs.getString("apellidos"));
			cliente.setDireccion(rs.getString("direccion"));
			cliente.setLocalidad(rs.getString("localidad"));
			
			return cliente;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return null;
		
	}
	
}
