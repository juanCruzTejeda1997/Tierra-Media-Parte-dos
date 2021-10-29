package model;


public class Atraccion {
	private int id;
	public int cupo;
	int tipoid;
	tipo tipo;
	private double tiempo;
	private double costo;
	private String nombre;
	
	public Atraccion(String nombre, double costo,  double tiempo,  int cupo, int tipoid) {
		this.nombre = nombre;
		this.costo = costo;
		this.tiempo = tiempo;
		this.cupo = cupo;
	}
	
	public Atraccion(int id, String nombre, double costo, double tiempo,  int cupo, int tipoid) {
		this.nombre = nombre;
		this.costo = costo;
		this.tiempo = tiempo;
		this.cupo = cupo;
		this.tipoid = tipoid;
		this.id = id;
	}
	public Atraccion(int id, String nombre, double costo, double tiempo,  int cupo, tipo tipo) {
		this.id= id;
		this.nombre = nombre;
		this.costo = costo;
		this.tiempo = tiempo;
		this.cupo = cupo;
		this.tipo = tipo;
		
	}
	
	





	public double getCosto() {
		return this.costo;
	}
	
	public double getTiempo() {
		return this.tiempo;
	}
	
	public int getCupo() {
		return this.cupo;
	}
	
	@Override
	public String toString() {
		
		if(this.tipo != null ) {
			return "ID = " + this.id + "  NOMBRE = " + this.nombre + " ,con un costo de = " + this.costo + ", con un tiempo de = " + this.tiempo + " ,con un cupo de = " + this.cupo + " ,con un tipo de = " + this.tipo ;
			
		}		
		return  "ID = " + this.id + "  NOMBRE = " + this.nombre + " ,con un costo de = " + this.costo + ", con un tiempo de = " + this.tiempo + " ,con un cupo de = " + this.cupo + " ,con un tipo de = " + this.tipoid ;
	}
	
	

	public int getId() {
		return id;
	}

	public String getNombre() {
		return this.nombre;
	
	}

	public int getTipo() {
		return this.tipoid;
		
	}
}