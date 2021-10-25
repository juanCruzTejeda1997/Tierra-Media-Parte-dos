package model;


public class Atraccion {

	public String nombre;
	public int cupo;
	private double tiempo;
	private double costo;
	private int tipoAtraccion;
	
	public Atraccion(String nombre, int cupo, double tiempo, double costo, int tipoAtraccion) {
		super();
		this.nombre = nombre;
		this.cupo = cupo;
		this.tiempo = tiempo;
		this.costo = costo;
		this.tipoAtraccion = tipoAtraccion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCupo() {
		return cupo;
	}

	public void setCupo(int cupo) {
		this.cupo = cupo;
	}

	public double getTiempo() {
		return tiempo;
	}

	public void setTiempo(double tiempo) {
		this.tiempo = tiempo;
	}

	public double getCosto() {
		return costo;
	}

	public void setCosto(double costo) {
		this.costo = costo;
	}

	public int getTipoAtraccion() {
		return tipoAtraccion;
	}

	public void setTipoAtraccion(int tipoAtraccion) {
		this.tipoAtraccion = tipoAtraccion;
	}
	
	
	
	
	
}

