package model;

public abstract class Promocion{


	protected int id;
	private String nombre;
	private int atraccion1_id;
	private int atraccion2_id;
	private double tiempo;
	private double costo;
	protected int tipo_id;
	public Atraccion atraccion1;
	public Atraccion atraccion2;
	public Atraccion atraccion_gratis;
	protected tipo tipo;
	
	

	public Promocion(int id, String nombre, int atraccion1_id, int atraccion2_id, double tiempo, double costo,
			int tipo_id) {
		this.id = id;
		this.nombre = nombre;
		this.atraccion1_id = atraccion1_id;
		this.atraccion2_id = atraccion2_id;
		this.tiempo = tiempo;
		this.costo = costo;
		this.tipo_id = tipo_id;
	}
	
	public Promocion(int id, String nombre, Atraccion atraccion1, Atraccion atraccion2, double tiempo, double costo,
			tipo tipo) {
		this.id = id;
		this.nombre = nombre;
		this.atraccion1= atraccion1;
		this.atraccion2= atraccion2;
		this.tiempo = tiempo;
		this.costo = costo;
		this.tipo= tipo;
	}
	
	
	public Promocion(String nombre, int atraccion1_id, int atraccion2_id, double tiempo, double costo,
			int tipo_id) {
		
		this.nombre = nombre;
		this.atraccion1_id= atraccion1_id;
		this.atraccion2_id= atraccion2_id;
		this.tiempo = tiempo;
		this.costo = costo;
		this.tipo_id= tipo_id;
	}
	
	public Promocion(int id, String nombre, Atraccion atraccion1 , Atraccion atraccion2, double tiempo, double costo,
			int tipo_id) {
		
		this.nombre = nombre;
		this.atraccion1= atraccion1;
		this.atraccion2= atraccion2;
		this.tiempo = tiempo;
		this.costo = costo;
		this.tipo_id= tipo_id;
	}

	public int getId() {
		return id;
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

	public Atraccion getAtraccion1() {
		return atraccion1;
	}

	public Atraccion getAtraccion2() {
		return atraccion2;
	}

	public Atraccion getAtraccion_gratis() {
		return atraccion_gratis;
	}

	public tipo getTipo() {
		return tipo;
	}
	






	



	
}