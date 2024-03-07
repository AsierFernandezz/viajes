package modelo;

import java.util.ArrayList;
import java.util.Scanner;

import vista.Formulario;
import vista.Menu;
import vista.Visor;

public class GestorGeneral {
	
	public void run() {
		
		GestorBBDD gestorbbdd = new GestorBBDD();
		ClienteModelo cm = new ClienteModelo();
		ReservaModelo rm = new ReservaModelo();
		HabitacionModelo hm = new HabitacionModelo();
		HotelModelo hom = new HotelModelo();
		
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
					ArrayList<Cliente> clientes = cm.VerTodosClientes();
					gestorbbdd.cerrar();
					Visor.mostrarClientes(clientes);
					break;

				case Menu.INSERTAR_CLIENTES:
					gestorbbdd.conectar();
					cm.insertarCliente(Formulario.introducirDatosCliente(scan));
					gestorbbdd.cerrar();
					break;
				
				case Menu.VISUALIZAR_CLIENTE:
					gestorbbdd.conectar();
					Cliente cliente = cm.getClienteXDni(Formulario.getDni(scan));
					gestorbbdd.cerrar();
					break;
					
				case Menu.MODIFICAR_CLIENTES:
					gestorbbdd.conectar();
					String DNI= Formulario.getDni(scan);
					cliente = cm.getClienteXDni(DNI);
					cm.modificarCliente(DNI, Formulario.introducirDatosCliente(scan));
					break;
					
				case Menu.ELIMINAR_CLIENTES:
					gestorbbdd.conectar();
					cm.borrarCliente(Formulario.getDni(scan));
					gestorbbdd.cerrar();
					break;
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
					String nombreHotel = Formulario.getNombreHotel(scan);
					Hotel hotel = hom.getHotel(nombreHotel);
					ArrayList<Habitacion> habitaciones = hom.getHoteles(hotel);
					gestorbbdd.cerrar();
					Visor.mostrarHabitaciones(habitaciones);
					break;

				case Menu.ELIMINAR_HABITACIONES:
					gestorbbdd.conectar();
					
					nombreHotel = Formulario.getNombreHotel(scan);
					hotel = hom.getHotel(nombreHotel);
					
					habitaciones = hom.getHoteles(hotel);
					Visor.mostrarHabitaciones(habitaciones);
					
					int idHabitacion = Formulario.idHabitacion(scan);
					hm.eliminarHabitacion(idHabitacion);
					
					gestorbbdd.cerrar();
					
					break;
					
				default:
					break;
				}
				
			case Menu.RESERVAS:
				
				Menu.menuReservas();
				opcion = Integer.parseInt(scan.nextLine());
				
				switch (opcion) {
				case Menu.VER_TODOS_RESERVAS:
					gestorbbdd.conectar();
					ArrayList<Reserva> reservas = rm.verReservas();
					gestorbbdd.cerrar();
					Visor.mostrarReservas(reservas);
					break;
				
				case Menu.REALIZAR_RESERVAS:
					
					gestorbbdd.conectar();
					//pedir dni 
					String dniCliente = Formulario.getDni(scan);
					Cliente cliente = cm.getClienteXDni(dniCliente);
					
					//mostrar cliente 
					Visor.mostrarCliente(cliente);
					
					//pedir nombre del hotel donde se desea alojar
					String nombreHotel = Formulario.getNombreHotel(scan);
					Hotel hotel = hom.getHotel(nombreHotel);
					
					ArrayList<Habitacion> habitaciones = hom.getHoteles(hotel);
					
					Visor.mostrarHabitaciones(habitaciones);
					
					//pedir datos para realizar la reserva
					Reserva reserva = Formulario.introducirDatosReserva(scan);
					reserva.setCliente(cliente);
					rm.realizarReserva(reserva);
					
					gestorbbdd.cerrar();
					
					break;

				case Menu.MOSTRAR_RESERVA_CLIENTE:
					gestorbbdd.conectar();
					
					dniCliente = Formulario.getDni(scan);
					cliente = cm.getClienteXDni(dniCliente);
					cm.getClienteXDni(dniCliente);
					
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
