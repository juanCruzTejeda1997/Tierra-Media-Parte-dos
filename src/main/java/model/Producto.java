package model;

public abstract class Producto {
	protected String nombre;
	protected int tipo;
	
	public  Producto(String nombre, int tipo){
		this.nombre = nombre;
		this.tipo = tipo;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public int getTipo() {
		return this.tipo;
	}
}
