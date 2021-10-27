package model;

public abstract class Promocion extends Producto{
	@SuppressWarnings("unused")
	private int tipo_promocion_id;
	Atraccion [] atracciones;
	
	protected double total;
	private int atraccionGratis;
	protected int tipo_id;
	
	/*
	public Promocion(String nombre, int tipo, int tipo_promocion, double descuento, double total, int atraccion_gratis) {
		super(nombre, tipo);
		this.tipo_promocion = tipo_promocion;
		this.descuento = descuento;
		this.total = total;
		this.atraccionGratis = atraccion_gratis;
	}
	*/
	public Promocion(String nombre, int tipo_id, int tipo_promocion_id) {
		super(nombre, tipo_id);
		this.tipo_promocion_id = tipo_promocion_id;
	}
	
	public String getNombre() {
		return super.nombre;
	}
	
	public Integer getAtraccionGratis() {
		return this.atraccionGratis;
	}
	
	public Integer getTipoPromocion() {
		return this.tipo_promocion_id;
	}
	
	public int getTipo() {
		return this.tipo_id;
	}
	
	public Double getTotal() {
		return this.total;
	}
}