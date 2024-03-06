package vista;

public class Menu {
	
	public static final int SALIR = 0;
	
	//Principal
	public static final int CLIENTES = 1;
	public static final int HABITACIONES = 2;
	public static final int RESERVAS = 3;
	
	
	//Clientes
	public static final int VER_TODOS_CLIENTES = 1;
	public static final int INSERTAR_CLIENTES = 2;
	public static final int ELIMINAR_CLIENTES = 3;
	public static final int MODIFICAR_CLIENTES = 4;
	
	//Hotel
	public static final int VER_TODOS_HOTELES = 1;
	public static final int INSERTAR_HOTELES = 2;
	public static final int ELIMINAR_HOTELES = 3;
	public static final int MODIFICAR_HOTELES = 4;
	
	//Habitaciones
	public static final int VER_TODOS_HABITACIONES = 1;
	public static final int INSERTAR_HABITACIONES = 2;
	public static final int ELIMINAR_HABITACIONES = 3;
	public static final int MODIFICAR_HABITACIONES = 4;
	public static final int VER_HABITACIONES_HOTEL = 5;
	
	//Reserva
	public static final int VER_TODOS_RESERVAS = 1;
	public static final int REALIZAR_RESERVAS = 2;
	public static final int ELIMINAR_RESERVAS = 3;
	public static final int MODIFICAR_RESERVAS = 4;
	
	public static void menuPrincipal() {
		System.out.println("--Menu--");
		System.out.println(SALIR + "- Salir");
		System.out.println(CLIENTES + "- Clientes");
		System.out.println(HABITACIONES + "- Habitaciones");
		System.out.println(RESERVAS + "- Reservas");
	}
	
	public static void menuClientes() {
		System.out.println("--Menu--");
		System.out.println(VER_TODOS_CLIENTES + "- Ver todos los clientes");
		System.out.println(INSERTAR_CLIENTES + "- Insertar clientes");
		System.out.println(ELIMINAR_CLIENTES + "- Eliminar clientes");
		System.out.println(MODIFICAR_CLIENTES + "Modificar clientes");
	}
	
	public static void menuHabitaciones() {
		System.out.println("--MENU--");
		System.out.println(ELIMINAR_HABITACIONES + "- Eliminar habitaciones");
		System.out.println(VER_HABITACIONES_HOTEL + "- Ver todas las habitaciones de un hotel");
	}
	
	public static void menuReservas() {
		System.out.println("--MENU--");
		System.out.println(VER_TODOS_RESERVAS + "- Ver todas las reservas");
		System.out.println(REALIZAR_RESERVAS + "- Realiza una reserva");
	}
	
}

	