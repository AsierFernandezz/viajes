package modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import controlador.Conector;

public class ReservaModelo extends Conector{
	
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
}
