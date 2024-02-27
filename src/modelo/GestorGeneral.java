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
	
			default:
				break;
			}
		}while(Menu.SALIR != opcion);	
	}
}
