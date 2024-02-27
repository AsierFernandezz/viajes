package vista;

import java.util.ArrayList;

import modelo.Cliente;

public class Visor {

	public static void mostrarClientes(ArrayList<Cliente> clientes) {
		for (Cliente cliente : clientes) {
			System.out.println(cliente);
		}
	}
	
}
