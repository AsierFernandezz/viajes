package modelo;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import controlador.Conector;


public class GestorBBDD extends Conector{

	
	
	
	
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
