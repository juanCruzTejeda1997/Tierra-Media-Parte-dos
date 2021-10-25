package model;


public abstract class Promocion{
	protected String nombre;
	protected int tipoPromocion;
	protected int tipoDeAtraccion;
	protected double descuento ;
	protected double total;
	
	
	public Promocion(String nombre, int tipoPromocion, int tipoDeAtraccion, double descuento, double total) {
		this.nombre = nombre;
		this.tipoPromocion = tipoPromocion;
		this.tipoDeAtraccion = tipoDeAtraccion;
		this.descuento = descuento;
		this.total = total;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public int getTipoPromocion() {
		return tipoPromocion;
	}


	public void setTipoPromocion(int tipoPromocion) {
		this.tipoPromocion = tipoPromocion;
	}


	public int getTipoDeAtraccion() {
		return tipoDeAtraccion;
	}


	public void setTipoDeAtraccion(int tipoDeAtraccion) {
		this.tipoDeAtraccion = tipoDeAtraccion;
	}


	public double getDescuento() {
		return descuento;
	}


	public void setDescuento(double descuento) {
		this.descuento = descuento;
	}


	public double getTotal() {
		return total;
	}


	public void setTotal(double total) {
		this.total = total;
	}
	
	
	

}
	
	
