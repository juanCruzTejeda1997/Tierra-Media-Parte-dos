package model;


public class Usuario {

    private int id;
	private String nombre;
	private double presupuesto;
	private double tiempo_disponible;
	private int tipo_preferencia_id;

	public Usuario(int id, String nombre, double presupuesto, double tiempo_disponible, int tipo_preferencia_id) {
		this.nombre = nombre;
		this.presupuesto = presupuesto;
		this.tiempo_disponible = tiempo_disponible;
		this.tipo_preferencia_id = tipo_preferencia_id;
	}
	
	public String toString() {
		return this.nombre + " prefiere las atracciones del tipo " + this.tipo_preferencia_id + ", tiene " + this.presupuesto + " monedas disponibles y cuenta con " + this.tiempo_disponible + " horas disponibles";
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
}
