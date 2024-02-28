package modelo;

import java.util.Date;

public class Reserva {

	private int id;
	private Habitacion habitacion;
	private Cliente cliente;
	private Date desde;
	private Date hasta;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Habitacion gethabitacion() {
		return habitacion;
	}
	public void sethabitacion(Habitacion habitacion) {
		this.habitacion = habitacion;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Date getDesde() {
		return desde;
	}
	public void setDesde(Date desde) {
		this.desde = desde;
	}
	public Date getHasta() {
		return hasta;
	}
	public void setHasta(Date hasta) {
		this.hasta = hasta;
	}
	
	public Reserva() {
		
	}
	
	public Reserva(int id, Habitacion habitacion, Cliente cliente, Date desde, Date hasta) {
		super();
		this.id = id;
		this.habitacion = habitacion;
		this.cliente = cliente;
		this.desde = desde;
		this.hasta = hasta;
	}
	@Override
	public String toString() {
		return "Reserva [id=" + id + ", habitacion=" + habitacion + ", cliente=" + cliente + ", desde=" + desde
				+ ", hasta=" + hasta + "]";
	}
	

	
	
	
}

