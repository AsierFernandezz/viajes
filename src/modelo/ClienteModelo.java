package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import controlador.Conector;

public class ClienteModelo  extends Conector{
	
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
	
	public boolean borrarCliente(String DNI) {
		String sql = "DELETE FROM clientes WHERE DNI=?";
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, DNI);
			pst.execute();
			
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean modificarCliente(String DNI, Cliente c) {
		String sql = "UPDATE clientes SET DNI=?, nombre=?, apellidos=?, direccion=?, localidad=? WHERE DNI = ?";
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, c.getDni());
			pst.setString(2, c.getNombre());
			pst.setString(3, c.getApellidos());
			pst.setString(4, c.getDireccion());
			pst.setString(5, c.getLocalidad());
			pst.setString(6, DNI);
			pst.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}		
	}
}
