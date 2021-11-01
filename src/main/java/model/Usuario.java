package model;

import java.util.ArrayList;
import java.util.Collections;

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
			return "| NOMBRE = " + this.nombre + " TIPO PREFERENCIA =" + this.tipo_preferencia
					+ " PRESUPUESTO = " + this.presupuesto + " TIEMPO DISPONIBLE = " + this.tiempo_disponible;
		}

		return " | NOMBRE = " + this.nombre + " ID PREFERENCIA =" + this.tipo_preferencia_id
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
	
	public static ArrayList<Producto> listaDePreferencias(ArrayList<Producto> productos, tipo preferencia) {
		Collections.sort(productos, new Ofertable(preferencia));
		return productos;
	}
}
