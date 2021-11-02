package model;

import java.util.Arrays;
import java.util.Objects;

public abstract class Promocion extends Producto {

	protected int id;
	private String nombre;
	private int atraccion1_id;
	private int atraccion2_id;
	private double tiempo;
	private double costo;
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
	
	public Promocion(String nombre, int atraccion1_id, int atraccion2_id, double tiempo, double costo,
			int tipo_id) {
		
		this.nombre = nombre;
		this.atraccion1_id= atraccion1_id;
		this.atraccion2_id= atraccion2_id;
		this.tiempo = tiempo;
		this.costo = costo;
		this.tipo_id= tipo_id;
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
		result = prime * result + Arrays.hashCode(atracciones);
		result = prime * result + Objects.hash(atraccion1, atraccion2, nombre, tipo);
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
		return Objects.equals(atraccion1, other.atraccion1) && Objects.equals(atraccion2, other.atraccion2)
				&& Arrays.equals(atracciones, other.atracciones) && Objects.equals(nombre, other.nombre)
				&& tipo == other.tipo;
	}


}