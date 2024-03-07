package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import controlador.Conector;

public class ReservaModelo extends Conector{
	
	ClienteModelo cm = new ClienteModelo();
	HabitacionModelo hm = new HabitacionModelo();
	
	public ArrayList<Reserva> verReservas(){
		
		ArrayList<Reserva> reservas = new ArrayList<Reserva>();
		String sql = "SELECT * FROM reservas";
		
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				Reserva reserva = new Reserva();
				reserva.setId(rs.getInt("id"));
				
				Habitacion habitacionTemp = new Habitacion();
				habitacionTemp.setId(rs.getInt("id_habitacion"));
				reserva.sethabitacion(habitacionTemp);
				
				Cliente clienteTemp = new Cliente();
				clienteTemp.setDni(rs.getString("dni"));
				reserva.setCliente(clienteTemp);
				
				reserva.setDesde(rs.getDate("desde"));
				reserva.setHasta(rs.getDate("hasta"));
				
				reservas.add(reserva);
				
				return reservas;
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
		
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
	
	public ArrayList<Reserva> getReservas(){
		ArrayList<Reserva> reservas = new ArrayList<>();
		String sql = "SELECT * FROM reservas";
		try {
			ResultSet rs = con.createStatement().executeQuery(sql);
			
			while(rs.next()) {
				Reserva r = new Reserva();
				
				r.setId(rs.getInt("id"));
				r.setCliente(cm.getClienteXDni(rs.getString("dni")));
				r.sethabitacion(hm.getHabitacion(rs.getInt("id_habitacion")));
				r.setDesde((java.util.Date)rs.getDate("desde"));
				r.setHasta((java.util.Date)rs.getDate("hasta"));
				
				reservas.add(r);
			}
			reservas.sort(new ComparatorFecha());
		} catch (SQLException e) {
			System.out.println("Error getReservas");
			e.printStackTrace();
		}
		return reservas;
	}
}
