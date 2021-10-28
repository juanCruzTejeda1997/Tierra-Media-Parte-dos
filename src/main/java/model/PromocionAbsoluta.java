package model;

public class PromocionAbsoluta extends Promocion {

	public PromocionAbsoluta(String nombre, int atraccion1_id, int atraccion2_id, double tiempo, double costo,
			int tipo_id) {
		super(nombre, atraccion1_id, atraccion2_id, tiempo, costo, tipo_id);
		// TODO Auto-generated constructor stub
	}

	public PromocionAbsoluta(int id, String nombre, int atraccion1_id, int atraccion2_id, double tiempo, double costo,
			int tipo_id) {
		super(nombre, atraccion1_id, atraccion2_id, tiempo, costo, tipo_id);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "PromocionAbsoluta [  getId()=" + getId() + "getNombre()=" + getNombre() + ", getAtraccion1_id()=" + getAtraccion1_id()
				+ ", getAtraccion2_id()=" + getAtraccion2_id() + ", getTiempo()=" + getTiempo() + ", getCosto()="
				+ getCosto() + ", getTipo_id()=" + getTipo_id() + "]";
	}

	
	
	
}
