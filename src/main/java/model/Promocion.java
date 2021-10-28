package model;

public abstract class Promocion{



	private int id;
	private String nombre;
	private int atraccion1_id;
	private int atraccion2_id;
	private double tiempo;
	private double costo;
	private int tipo_id;
	
	
	public Promocion(String nombre, int atraccion1_id, int atraccion2_id, double tiempo, double costo, int tipo_id) {
		super();
		this.nombre = nombre;
		this.atraccion1_id = atraccion1_id;
		this.atraccion2_id = atraccion2_id;
		this.tiempo = tiempo;
		this.costo = costo;
		this.tipo_id = tipo_id;
	}



	public String getNombre() {
		return nombre;
	}


	public int getAtraccion1_id() {
		return atraccion1_id;
	}


	public int getAtraccion2_id() {
		return atraccion2_id;
	}


	public double getTiempo() {
		return tiempo;
	}


	public double getCosto() {
		return costo;
	}


	public int getTipo_id() {
		return tipo_id;
	}


	public int getId() {
		return id;
	}
	
	
}