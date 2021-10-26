package model;

public class Usuario {

	private String nombre;
	private double presupuesto;
	private double tiempoDisponible;
	private int preferencia;

	public Usuario(String nombre, double presupuesto, double tiempoDisponible, int preferencia) {
		this.nombre = nombre;
		this.presupuesto = presupuesto;
		this.tiempoDisponible = tiempoDisponible;
		this.preferencia = preferencia;
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

	public Integer getPreferencia() {
		return this.preferencia;
	}
}
