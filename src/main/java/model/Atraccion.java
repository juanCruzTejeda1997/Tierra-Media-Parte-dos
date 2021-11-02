package model;

import java.util.Objects;

public class Atraccion extends Producto{
	
	
	
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
		return id;
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
			return "||ID = " + super.getId() + "  NOMBRE = " + super.getNombre() + " COSTO = " + super.getCosto() + " TIEMPO = "
					+ super.getTiempo() + " CUPO = " + super.getCupo() + " TIPO TIPO = " + super.getTipo();

		}
		return "||ID = " + super.getId() + "  NOMBRE = " + super.getNombre() + " COSTO = " +super. getCosto() + " TIEMPO = " + super.getTiempo()
				+ " CUPO = " + super.getCupo() + " TIPO ID = " + super.getTipoId();
	}

	@Override
	protected void restarCupo() {
		super.cupo-=1;
		
	}

	@Override
	protected boolean esPromo() {
		
		return false;
	}

	@Override
	public boolean contiene(Producto producto) {
		if (producto.esPromo()) {
			return producto.contiene(this);
		}
		return this.equals(producto);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(costo, cupo, nombre, tiempo, tipo);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Atraccion other = (Atraccion) obj;
		return Double.doubleToLongBits(costo) == Double.doubleToLongBits(other.costo) && cupo == other.cupo
				&& Objects.equals(nombre, other.nombre)
				&& Double.doubleToLongBits(tiempo) == Double.doubleToLongBits(other.tiempo)
				&& tipo == other.tipo;
	}
	
	
}