package model;

public abstract class Promocion{


	protected int id;
	private String nombre;
	private int atraccion1_id;
	private int atraccion2_id;
	private double tiempo;
	private double costo;
	protected int tipo_id;
	
	
	

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
	
	


	public Promocion(String nombre2, int atraccion1_id2, int atraccion2_id2, double tiempo2, double costo2,
			int tipo_id2) {
		// TODO Auto-generated constructor stub
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