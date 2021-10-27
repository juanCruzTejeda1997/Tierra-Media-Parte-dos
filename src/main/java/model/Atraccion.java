package model;


public class Atraccion extends Producto{
	public int cupo;
	private double tiempo;
	private double costo;
	
	public Atraccion(String nombre, int tipo, double costo, double tiempo,  int cupo) {
		super(nombre, tipo);
		this.costo = costo;
		this.tiempo = tiempo;
		this.cupo = cupo;
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
		return super.nombre + "(" + this.costo + " monedas, " + this.tiempo + " horas, " + this.cupo + " lugares, tipo: " + super.tipo + ")";
	}
}