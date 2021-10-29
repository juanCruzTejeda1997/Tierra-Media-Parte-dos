package model;

public class Atraccion {

	private int id;
	private String nombre;
	private double costo;
	private double tiempo;
	private int cupo;
	private int tipoId;
	private tipo tipo;

	public Atraccion(int id, String nombre, double costo, double tiempo, int cupo, int tipoId) {
		
		this.id = id;
		this.nombre = nombre;
		this.costo = costo;
		this.tiempo = tiempo;
		this.cupo = cupo;
		this.tipoId = tipoId;
		
	}
	
public Atraccion(int id, String nombre, double costo, double tiempo, int cupo, tipo tipo) {
		
		this.id = id;
		this.nombre = nombre;
		this.costo = costo;
		this.tiempo = tiempo;
		this.cupo = cupo;
		this.tipo = tipo;
	}

public Atraccion(String nombre, double costo, double tiempo, int cupo, int tipoId) {
	
	
	this.nombre = nombre;
	this.costo = costo;
	this.tiempo = tiempo;
	this.cupo = cupo;
	this.tipoId = tipoId;
	
}




	public int getId() {
	return this.id;
}

public String getNombre() {
	return this.nombre;
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

public int getTipoId() {
	return this.tipoId;
}

public tipo getTipo() {
	return this.tipo;
}

	@Override
	public String toString() {

		if (this.tipo != null) {
			return "||ID = " + getId() + "  NOMBRE = " + getNombre() + " COSTO = " + getCosto() + " TIEMPO = "
					+ getTiempo() + " CUPO = " + getCupo() + " TIPO TIPO = " + getTipo();

		}
		return "||ID = " + getId() + "  NOMBRE = " + getNombre() + " COSTO = " + getCosto() + " TIEMPO = " + getTiempo()
				+ " CUPO = " + getCupo() + " TIPO ID = " + getTipoId();
	}

	
}