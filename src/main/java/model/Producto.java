package model;

import java.util.ArrayList;

import turismoTierraMedia.Producto;




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
	
	public abstract void restarCupo() ;

	protected abstract boolean esPromo();
	
	public boolean tieneCupo() {
		return this.cupo >= 1;
	}
	

	public abstract boolean contiene(Producto producto);



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
		return this.cupo;
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





	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(costo);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + cupo;
		result = prime * result + id;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((productos == null) ? 0 : productos.hashCode());
		temp = Double.doubleToLongBits(tiempo);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
		result = prime * result + tipoId;
		return result;
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
		if (Double.doubleToLongBits(costo) != Double.doubleToLongBits(other.costo))
			return false;
		if (cupo != other.cupo)
			return false;
		if (id != other.id)
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (productos == null) {
			if (other.productos != null)
				return false;
		} else if (!productos.equals(other.productos))
			return false;
		if (Double.doubleToLongBits(tiempo) != Double.doubleToLongBits(other.tiempo))
			return false;
		if (tipo != other.tipo)
			return false;
		if (tipoId != other.tipoId)
			return false;
		return true;
	}
	

	

		

}
