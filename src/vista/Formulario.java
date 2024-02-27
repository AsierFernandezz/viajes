package vista;

import java.util.Scanner;

import modelo.Cliente;

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
	
}
