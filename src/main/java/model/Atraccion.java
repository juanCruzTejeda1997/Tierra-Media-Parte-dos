package model;





public class Atraccion extends Producto{

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
			return "||ID = " + this.getId() + "  NOMBRE = " + this.getNombre() + " COSTO = " + this.getCosto() + " TIEMPO = "
					+ this.getTiempo() + " CUPO = " + this.getCupo() + " TIPO TIPO = " + this.getTipo();

		}
		return "||ID = " + this.getId() + "  NOMBRE = " + this.getNombre() + " COSTO = " +this. getCosto() + " TIEMPO = " + this.getTiempo()
				+ " CUPO = " + this.getCupo() + " TIPO ID = " + this.getTipoId();
	}

	@Override
	public void restarCupo() {
		 this.cupo-=1;
		
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
		long temp;
		temp = Double.doubleToLongBits(costo);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + cupo;
		result = prime * result + id;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
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
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Atraccion other = (Atraccion) obj;
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
		if (Double.doubleToLongBits(tiempo) != Double.doubleToLongBits(other.tiempo))
			return false;
		if (tipo != other.tipo)
			return false;
		if (tipoId != other.tipoId)
			return false;
		return true;
	}
	
	

	
}