package model;

import java.util.Collections;
import java.util.LinkedList;

import DAO.ItinerarioDAOImpl;



public class Usuario {

    private int id;
	private String nombre;
	private double presupuesto;
	private double tiempo_disponible;
	private int tipo_preferencia_id;
	private tipo tipo_preferencia;

	public Usuario(String nombre, double presupuesto, double tiempo_disponible, int tipo_preferencia_id) {
		this.nombre = nombre;
		this.presupuesto = presupuesto;
		this.tiempo_disponible = tiempo_disponible;
		this.tipo_preferencia_id = tipo_preferencia_id;
	}


	public Usuario(int id, String nombre, double presupuesto, double tiempo_disponible, tipo tipo_preferencia) {
		this.id = id;
		this.nombre = nombre;
		this.presupuesto = presupuesto;
		this.tiempo_disponible = tiempo_disponible;
		this.tipo_preferencia = tipo_preferencia;
	}

	public Usuario(int id, String nombre, double presupuesto, double tiempo_disponible, int tipo_preferencia_id) {
		this.id = id;
		this.nombre = nombre;
		this.presupuesto = presupuesto;
		this.tiempo_disponible = tiempo_disponible;
		this.tipo_preferencia_id = tipo_preferencia_id;
	}

	public String toString() {
		if (this.tipo_preferencia != null) {
			return "| ID = " + this.id + " NOMBRE = " + this.nombre + " TIPO PREFERENCIA =" + this.tipo_preferencia
					+ " PRESUPUESTO = " + this.presupuesto + " TIEMPO DISPONIBLE = " + this.tiempo_disponible;
		}

		return " | ID = " + this.id + " NOMBRE = " + this.nombre + " ID PREFERENCIA =" + this.tipo_preferencia_id
				+ " PRESUPUESTO = " + this.presupuesto + " TIEMPO DISPONIBLE = " + this.tiempo_disponible;
	}

	public String getNombre() {
		return this.nombre;
	}

	public double getPresupuesto() {
		return this.presupuesto;
	}

	public double getTiempoDisponible() {
		return this.tiempo_disponible;
	}

	public Integer getTipo_preferencia_id() {
		return this.tipo_preferencia_id;
	}

	public int getId() {
		return id;
	}

	public tipo getTipo_preferencia() {
		return tipo_preferencia;
	}
	
	public static LinkedList<Producto> listaDePreferencias(LinkedList<Producto> productos, tipo preferencia) {
		Collections.sort(productos, new Ofertable(preferencia));
		return productos;
	}
	
	public  double restarPresupuesto (double costoProducto) {
		return this.presupuesto-= costoProducto;
	}
	public void restarTiempo(double tiempoDelProducto) {
		this.tiempo_disponible-=tiempoDelProducto;
	}
	


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		long temp;
		temp = Double.doubleToLongBits(presupuesto);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(tiempo_disponible);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((tipo_preferencia == null) ? 0 : tipo_preferencia.hashCode());
		result = prime * result + tipo_preferencia_id;
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (id != other.id)
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (Double.doubleToLongBits(presupuesto) != Double.doubleToLongBits(other.presupuesto))
			return false;
		if (Double.doubleToLongBits(tiempo_disponible) != Double.doubleToLongBits(other.tiempo_disponible))
			return false;
		if (tipo_preferencia != other.tipo_preferencia)
			return false;
		if (tipo_preferencia_id != other.tipo_preferencia_id)
			return false;
		return true;
	}
	
	public double gastoTotal() {
		ItinerarioDAOImpl it = new ItinerarioDAOImpl();
		double GastoTotalDelUsuario = 0;
		LinkedList<Itinerario> itinerario = it.buscarItinerarioPorUsuario(this.getNombre());
		
		for (Itinerario item : itinerario) {
			double gasto = 0;
			gasto +=item.calcularCosto();
			GastoTotalDelUsuario += gasto;
			gasto = 0;
		}
		return GastoTotalDelUsuario;
	}
	
	public double gastoTotalTiempo() {
		ItinerarioDAOImpl it = new ItinerarioDAOImpl();
		double TiempoGastadoDelUsuario = 0;
		LinkedList<Itinerario> itinerario = it.buscarItinerarioPorUsuario(this.getNombre());
		
		for (Itinerario item : itinerario) {
			
			double gasto = 0;
			gasto += item.calcularTiempo();
			TiempoGastadoDelUsuario += gasto;
			gasto = 0;
		}
		
		return TiempoGastadoDelUsuario;
		
	}
}