package model;

import java.util.Arrays;


public abstract class Promocion extends Producto {

	protected int id;
	private String nombre;
	private int atraccion1_id;
	private int atraccion2_id;
	protected double tiempo;
	protected double costo;
	protected int tipo_id;
	public Atraccion atraccion1;
	public Atraccion atraccion2;
	public Atraccion atraccion_gratis;
	protected tipo tipo;
	protected int cupo;
	Atraccion [] atracciones;
	
	

	public Promocion(int id, String nombre, int atraccion1_id, int atraccion2_id, double tiempo, double costo,
			int tipo_id, int cupo) {
		this.id = id;
		this.nombre = nombre;
		this.atraccion1_id = atraccion1_id;
		this.atraccion2_id = atraccion2_id;
		this.tiempo = tiempo;
		this.costo = costo;
		this.tipo_id = tipo_id;
		this.cupo = cupo;
	}
	
	public Promocion(int id, String nombre, Atraccion atraccion1, Atraccion atraccion2, double tiempo, double costo,
			tipo tipo, int cupo) {
		this.id = id;
		this.nombre = nombre;
		this.atraccion1= atraccion1;
		this.atraccion2= atraccion2;
		this.tiempo = tiempo;
		this.costo = costo;
		this.tipo= tipo;
		this.cupo = cupo;
	}
	
	
	public Promocion(String nombre, int atraccion1_id, int atraccion2_id, double tiempo, double costo,
			int tipo_id, int cupo) {
		
		this.nombre = nombre;
		this.atraccion1_id= atraccion1_id;
		this.atraccion2_id= atraccion2_id;
		this.tiempo = tiempo;
		this.costo = costo;
		this.tipo_id= tipo_id;
		this.cupo = cupo;
	}
	
	public Promocion(int id, String nombre, Atraccion atraccion1 , Atraccion atraccion2, double tiempo, double costo,
			int tipo_id, int cupo) {
		
		this.nombre = nombre;
		this.atraccion1= atraccion1;
		this.atraccion2= atraccion2;
		this.tiempo = tiempo;
		this.costo = costo;
		this.tipo_id= tipo_id;
		this.cupo = cupo;
	}
	protected Promocion(String nombre, Atraccion atraccion1, Atraccion atraccion2) {
		super(nombre);
		validarPromocion(atraccion1, atraccion2);
	}
	
	public int getCupo () {
		return this.cupo;
	}
	public void setCupo(int cupo) {
		this.cupo = cupo;
	}

	public int getId() {
		return id;
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

	public Atraccion getAtraccion1() {
		return atraccion1;
	}

	public Atraccion getAtraccion2() {
		return atraccion2;
	}

	public Atraccion getAtraccion_gratis() {
		return atraccion_gratis;
	}

	public tipo getTipo() {
		return tipo;
	}
	
	public abstract void restarCupo() ;
	

	@Override
	public boolean contiene(Producto producto) {
		return producto.contiene(atraccion1) || producto.contiene(atraccion2);
	}
	
	protected boolean esPromo() {
		return true;
	}
	
private void validarPromocion(Atraccion atraccion1, Atraccion atraccion2) {
		
		if (atraccion1.getTipo() != atraccion2.getTipo()) {
			throw new TipoAtraccionException ("Las atracciones deben ser del mismo tipo");
		}
		this.atraccion1 = atraccion1;
		this.atraccion2 = atraccion2;
		this.tipo = atraccion1.getTipo();
		
	}

@Override
public int hashCode() {
	final int prime = 31;
	int result = super.hashCode();
	result = prime * result + ((atraccion1 == null) ? 0 : atraccion1.hashCode());
	result = prime * result + atraccion1_id;
	result = prime * result + ((atraccion2 == null) ? 0 : atraccion2.hashCode());
	result = prime * result + atraccion2_id;
	result = prime * result + ((atraccion_gratis == null) ? 0 : atraccion_gratis.hashCode());
	result = prime * result + Arrays.hashCode(atracciones);
	long temp;
	temp = Double.doubleToLongBits(costo);
	result = prime * result + (int) (temp ^ (temp >>> 32));
	result = prime * result + cupo;
	result = prime * result + id;
	result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
	temp = Double.doubleToLongBits(tiempo);
	result = prime * result + (int) (temp ^ (temp >>> 32));
	result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
	result = prime * result + tipo_id;
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
	Promocion other = (Promocion) obj;
	if (atraccion1 == null) {
		if (other.atraccion1 != null)
			return false;
	} else if (!atraccion1.equals(other.atraccion1))
		return false;
	if (atraccion1_id != other.atraccion1_id)
		return false;
	if (atraccion2 == null) {
		if (other.atraccion2 != null)
			return false;
	} else if (!atraccion2.equals(other.atraccion2))
		return false;
	if (atraccion2_id != other.atraccion2_id)
		return false;
	if (atraccion_gratis == null) {
		if (other.atraccion_gratis != null)
			return false;
	} else if (!atraccion_gratis.equals(other.atraccion_gratis))
		return false;
	if (!Arrays.equals(atracciones, other.atracciones))
		return false;
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
	if (tipo_id != other.tipo_id)
		return false;
	return true;
}



}