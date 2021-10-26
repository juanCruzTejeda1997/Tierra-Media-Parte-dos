package model;

public abstract class Promocion extends Producto{
	private int tipo_promocion;
	Atraccion [] atracciones;
	
	private double total;
	private int atraccionGratis;
	
	/*
	public Promocion(String nombre, int tipo, int tipo_promocion, double descuento, double total, int atraccion_gratis) {
		super(nombre, tipo);
		this.tipo_promocion = tipo_promocion;
		this.descuento = descuento;
		this.total = total;
		this.atraccionGratis = atraccion_gratis;
	}
	*/
	public Promocion(String nombre, int tipo, int tipo_promocion) {
		super(nombre, tipo);
		this.tipo_promocion = tipo_promocion;
	}
	
	public String getNombre() {
		return super.nombre;
	}
	
	public Integer getAtraccionGratis() {
		return this.atraccionGratis;
	}
	
	public Integer getTipoPromocion() {
		return this.tipo_promocion;
	}
	
	public int getTipo() {
		return super.tipo;
	}
	
	public Double getTotal() {
		return this.total;
	}
}
