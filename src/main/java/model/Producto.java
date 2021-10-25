package model;

import java.util.ArrayList;
import java.util.Objects;


public abstract class Producto {
	ArrayList<Producto> productos = new ArrayList<Producto>();
	protected String nombre;
	protected double costo;
	protected double tiempo;
	int tipoDeAtraccion;
	protected int cupo;
	
	protected Producto (String nombre) {
		this.nombre = nombre;
	}
	
	public  Producto(String nombre, double costo, double tiempo, int tipoDeAtraccion, int cupo) {
		this.nombre = nombre;
		this.costo = costo;
		this.tiempo = tiempo;
		this.tipoDeAtraccion = tipoDeAtraccion;
		this.cupo = cupo;
	}
	
	public boolean tieneCupo() {
		return this.cupo >= 1;
	}
	
	public abstract String getNombre();

    public abstract double getCosto();

	public int getCupo() {
		return cupo;
	}

	public void setCupo(int cupo) {
		this.cupo = cupo;
	}
	
	protected abstract void restarCupo() ;

	protected abstract boolean esPromo();

	@Override
	public int hashCode() {
		return Objects.hash(costo, nombre, productos, tiempo, tipoDeAtraccion);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Producto other = (Producto) obj;
		return Double.doubleToLongBits(costo) == Double.doubleToLongBits(other.costo)
				&& Objects.equals(nombre, other.nombre) && Objects.equals(productos, other.productos)
				&& Double.doubleToLongBits(tiempo) == Double.doubleToLongBits(other.tiempo)
				&& tipoDeAtraccion == other.tipoDeAtraccion;
	}

	protected abstract double getTiempo();
	
	public abstract boolean contiene(Producto producto);
}
