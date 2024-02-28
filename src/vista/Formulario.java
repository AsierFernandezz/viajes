package vista;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import modelo.Cliente;
import modelo.Habitacion;
import modelo.Hotel;
import modelo.Reserva;

public class Formulario {
	
	Scanner scan = new Scanner(System.in)
;	
	public static Cliente introducirDatosCliente(Scanner scan) {
		
		Cliente cliente = new Cliente();
		
		System.out.println("Introduce el DNI del cliente");
		cliente.setDni(scan.nextLine());
		
		System.out.println("Introduce el Nombre del cliente");
		cliente.setNombre(scan.nextLine());
		
		System.out.println("Introduce el Apellido del cliente");
		cliente.setApellidos(scan.nextLine());
		
		System.out.println("Introduce el Direccion del cliente");
		cliente.setDireccion(scan.nextLine());
		
		System.out.println("Introduce la localidad del cliente");
		cliente.setLocalidad(scan.nextLine());
		
		return cliente;
		
	}
	
	public static Reserva introducirDatosReserva(Scanner scan) {
		
		Reserva reserva = new Reserva();
		
		Habitacion habitacionTemporal = new Habitacion();
		
		System.out.println("Introduce el id de la habitacion que desea reservar");
		
		int idHabitacion=Integer.parseInt(scan.nextLine());
		habitacionTemporal.setId(idHabitacion);
		reserva.sethabitacion(habitacionTemporal);
		
//		System.out.println("Introduce el dni");
//		reserva.getCliente().setDni(scan.nextLine());
		
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			
			System.out.println("Introduce la fecha en la que desea reservar(DD/MM/YYYY)");
			reserva.setDesde(sdf.parse(scan.nextLine()));
			
			System.out.println("Introduce la fecha Hasta la que desea reservar(DD/MM/YYYY)");
			reserva.setHasta(sdf.parse(scan.nextLine()));
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return reserva;
		
	}
	
	public static int idHabitacion(Scanner scan) {
		
		System.out.println("Introduce el id de la habitacion");
		int id_habitacion = Integer.parseInt(scan.nextLine());
		
		return id_habitacion;
		
	}
	
	public static String getNombreHotel(Scanner scan) {
		
		System.out.println("Introduce el nombre del hotel donde se desea alojar");
		String nombre_hotel = scan.nextLine();
				
		return nombre_hotel;
		
	}
	
	public static String getDni(Scanner scan) {
		
		System.out.println("Introduce el DNI");
		String dniCliente = scan.nextLine();
		
		return dniCliente;
		
	}
	
}
