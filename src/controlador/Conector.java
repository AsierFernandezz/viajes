package controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conector {
	
	private static String host = "localhost:8090";
	private static String BBDD = "viajes";
	private static String usuario = "root";
	private static String password = "";

	protected static Connection con;
	
	public  void conectar() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost/viajes";
			con = DriverManager.getConnection(url, "root", "");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void cerrar() {
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static String getHost() {
		return host;
	}

	public static void setHost(String host) {
		Conector.host = host;
	}

	public static String getBBDD() {
		return BBDD;
	}

	public static void setBBDD(String bBDD) {
		BBDD = bBDD;
	}

	public static String getUsuario() {
		return usuario;
	}

	public static void setUsuario(String usuario) {
		Conector.usuario = usuario;
	}

	public static String getPassword() {
		return password;
	}

	public static void setPassword(String password) {
		Conector.password = password;
	}

	public Connection getCon() {
		return con;
	}

	public void setCon(Connection con) {
		this.con = con;
	}
	
	
}
