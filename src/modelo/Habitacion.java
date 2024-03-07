package modelo;

public class Habitacion {

	private int id;
	private Hotel id_hotel;
	private int numero;
	private String descripcion;
	private double precio;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Hotel getId_hotel() {
		return id_hotel;
	}
	public void setId_hotel(Hotel id_hotel) {
		this.id_hotel = id_hotel;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int i) {
		this.numero = i;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	
	@Override
	public String toString() {
		return "Habitacion [id=" + id + ", id_hotel=" + id_hotel + ", numero=" + numero + ", descripcion=" + descripcion
				+ ", precio=" + precio + "]";
	}
	
	
	
}
