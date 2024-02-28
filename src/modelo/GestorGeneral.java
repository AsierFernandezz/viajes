package modelo;

import java.util.ArrayList;
import java.util.Scanner;

import vista.Formulario;
import vista.Menu;
import vista.Visor;

public class GestorGeneral {
	
	public void run() {
		
		GestorBBDD gestorbbdd = new GestorBBDD();
		
		int opcion;
		Scanner scan = new Scanner(System.in);

		do {
			Menu.menuPrincipal();
			opcion = Integer.parseInt(scan.nextLine());
			
			switch (opcion) {
			case Menu.CLIENTES:
				
				Menu.menuClientes();
				opcion = Integer.parseInt(scan.nextLine());
				
				switch (opcion) {
				case Menu.VER_TODOS_CLIENTES:
					gestorbbdd.conectar();
					ArrayList<Cliente> clientes = gestorbbdd.VerTodosClientes();
					gestorbbdd.cerrar();
					Visor.mostrarClientes(clientes);
					break;

				case Menu.INSERTAR_CLIENTES:
					gestorbbdd.conectar();
					gestorbbdd.insertarCliente(Formulario.introducirDatosCliente(scan));
					gestorbbdd.cerrar();
				default:
					break;
				}
				break;
	
			case Menu.HABITACIONES:
				
				Menu.menuHabitaciones();
				opcion = Integer.parseInt(scan.nextLine());
				
				switch (opcion) {
				case Menu.VER_HABITACIONES_HOTEL:
					gestorbbdd.conectar();
					String nombre_hotel = Formulario.getNombreHotel(scan);
					Hotel hotel = gestorbbdd.getIdHotelXNombre(nombre_hotel);
					ArrayList<Habitacion> habitaciones = gestorbbdd.getHotel(hotel);
					gestorbbdd.cerrar();
					Visor.mostrarHabitaciones(habitaciones);
					break;

				default:
					break;
				}
				
			case Menu.RESERVAS:
				
				Menu.menuReservas();
				opcion = Integer.parseInt(scan.nextLine());
				
				switch (opcion) {
				case Menu.REALIZAR_RESERVAS:
					
					gestorbbdd.conectar();
					//pedir dni 
					String dniCliente = Formulario.getDni(scan);
					Cliente cliente = gestorbbdd.getClienteXDni(dniCliente);
					/*
					 * reserva.setCliente(cliente);
					 */
					//mostrar cliente 
					Visor.mostrarCliente(cliente);
					
					//pedir nombre del hotel donde se desea alojar
					String nombreHotel = Formulario.getNombreHotel(scan);
					Hotel hotel = gestorbbdd.getIdHotelXNombre(nombreHotel);
					
					ArrayList<Habitacion> habitaciones = gestorbbdd.getHotel(hotel);
					
					Visor.mostrarHabitaciones(habitaciones);
					
					//pedir datos para realizar la reserva
					Reserva reserva = Formulario.introducirDatosReserva(scan);
					reserva.setCliente(cliente);
					gestorbbdd.realizarReserva(reserva);
					
					gestorbbdd.cerrar();
					
					break;

				default:
					break;
				}
			default:
				break;
			}
		}while(Menu.SALIR != opcion);	
	}
}
