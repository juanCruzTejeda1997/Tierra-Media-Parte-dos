package model;



import java.util.ArrayList;
import java.util.Collections;



public class Usuario {
	private String nombre;
	private double presupuesto;
	private double tiempoDisponible;
	private int preferencia;
	protected ArrayList<Producto> itinerario;
	
	public double gastoTotal() {
		
		double GastoTotalDelUsuario = 0;
		
		for (int i = 0; i < this.getItinerario().size(); i++) {
			
			double gasto = 0;
			gasto +=this.getItinerario().get(i).getCosto();
			GastoTotalDelUsuario += gasto;
			gasto = 0;
		}
		return GastoTotalDelUsuario;
	}
	
	public double gastoTotalTiempo() {
		double TiempoGastadoDelUsuario = 0;
		
		for (int i = 0; i < this.getItinerario().size(); i++) {
			
			double gasto = 0;
			gasto += this.getItinerario().get(i).getTiempo();
			TiempoGastadoDelUsuario += gasto;
			gasto = 0;
		}
		
		return TiempoGastadoDelUsuario;
		
	}

	public Usuario(String nombre, int preferencia, double presupuesto, double tiempoDisponible) {
		this.nombre = nombre;
		this.presupuesto = presupuesto;
		this.tiempoDisponible = tiempoDisponible;
		this.preferencia = preferencia;
	}
	
	public void crearItinerario() {
		this.itinerario = new ArrayList<Producto>();
	}
	
	public void agregarProducto(Producto producto) {
		itinerario.add(producto);
		restarPresupuesto(producto.getCosto());
		restarTiempo(producto.getTiempo());
	}
	
	public void restarTiempo(double tiempoDelProducto) {
		this.tiempoDisponible-=tiempoDelProducto;
	}
	
	public void restarPresupuesto(double costoDelProducto) {
		 this.presupuesto-=costoDelProducto;
	}
	public String toString() {
		return this.nombre + " prefiere las atracciones del tipo " + this.preferencia + ", tiene " + this.presupuesto + " monedas disponibles y cuenta con " + this.tiempoDisponible + " horas disponibles";
	}
	
	public String getNombre() {
		return nombre;
	}

	public double getPresupuesto() {
		return presupuesto;
	}

	public double getTiempoDisponible() {
		return tiempoDisponible;
	}

	public int getPreferencia() {
		return this.preferencia;
	}
	
	public ArrayList<Producto> getItinerario() {
		return itinerario;
	}

	public void setItinerario(ArrayList<Producto> itinerario) {
		this.itinerario = itinerario;
	}

	public static ArrayList<Producto> listaDePreferencias(ArrayList<Producto> productos, int preferencia) {
		Collections.sort(productos, new Ofertable(preferencia));
		return productos;
	}
}
