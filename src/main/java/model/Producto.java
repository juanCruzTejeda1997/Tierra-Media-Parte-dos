package model;




public abstract class Producto {
	protected String nombre;
	protected int tipo;
	
	public  Producto(String nombre, int tipo){
		this.nombre = nombre;
		this.tipo = tipo;
	}
	
	public Producto(String nombre2) {
		// TODO Auto-generated constructor stub
	}

	public String getNombre() {
		return this.nombre;
	}
	
	public int getTipo() {
		return this.tipo;
	}
}



