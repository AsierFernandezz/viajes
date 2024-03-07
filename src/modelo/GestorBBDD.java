package modelo;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import controlador.Conector;


public class GestorBBDD extends Conector{

	
	
	
	
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
	
	public Hotel getIdHotelXNombre(String nombreHotel) {
		
		String sql = "SELECT * FROM hoteles WHERE nombre = ?";
		
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, nombreHotel);
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
	
	
	
	public Habitacion editarHabitacion(Habitacion habitacion) {
		
		String sql = "UPDATE ";
		
		return habitacion;
		
	}
	
	public ArrayList<Reserva> getClienteConReservas (Cliente cliente){
		
		ArrayList<Reserva> reservas = new ArrayList<Reserva>();
		
		String sql = "SELECT * FROM reservas WHERE dni = ?";
		
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, cliente.getDni());
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				Reserva reserva = new Reserva();
				reserva.setId(rs.getInt("id"));
				reserva.gethabitacion().setId(rs.getInt("id_habitacion"));
				reserva.getCliente().setDni(rs.getString("dni"));
				reserva.setHasta(rs.getDate("desde"));
				reserva.setDesde(rs.getDate("hasta"));
				
				reservas.add(reserva);
				
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
		
	}
	
}
