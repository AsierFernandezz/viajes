package vista;

import java.util.ArrayList;

import modelo.Cliente;
import modelo.Habitacion;

public class Visor {

	public static void mostrarClientes(ArrayList<Cliente> clientes) {
		for (Cliente cliente : clientes) {
			System.out.println(cliente);
		}
	}
	
	public static void mostrarHabitaciones(ArrayList<Habitacion> habitaciones) {
		for (Habitacion habitacion : habitaciones) {
			System.out.println(habitacion);
		}
	}
	
	public static void mostrarCliente(Cliente cliente) {
		System.out.println(cliente);
	}
	
}
