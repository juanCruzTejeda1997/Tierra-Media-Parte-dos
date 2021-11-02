package model;

import java.util.ArrayList;
import java.util.Objects;


public abstract class Producto {
	ArrayList<Producto> productos = new ArrayList<Producto>();
	protected int id;
	protected String nombre;
	protected double costo;
	protected double tiempo;
	protected int cupo;
	public int tipoId;
	protected tipo tipo;

	public Producto() {
	}
	
	public Producto (String nombre) {
		this.nombre = nombre;
	}
	
	protected abstract void restarCupo() ;

	protected abstract boolean esPromo();
	
	public boolean tieneCupo() {
		return this.cupo >= 1;
	}
	

	public abstract boolean contiene(Producto producto);

	@Override
	public int hashCode() {
		return Objects.hash(costo, nombre, productos, tiempo, tipo, tipoId);
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
				&& tipo == other.tipo;
	}


	public ArrayList<Producto> getProductos() {
		return productos;
	}

	public void setProductos(ArrayList<Producto> productos) {
		this.productos = productos;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getCosto() {
		return costo;
	}

	public void setCosto(double costo) {
		this.costo = costo;
	}

	public double getTiempo() {
		return tiempo;
	}

	public void setTiempo(double tiempo) {
		this.tiempo = tiempo;
	}

	public int getCupo() {
		return cupo;
	}

	public void setCupo(int cupo) {
		this.cupo = cupo;
	}

	public int getTipoId() {
		return tipoId;
	}

	public void setTipoId(int tipoId) {
		this.tipoId = tipoId;
	}

	public tipo getTipo() {
		return tipo;
	}

	public void setTipo(tipo tipo) {
		this.tipo = tipo;
	}
}



