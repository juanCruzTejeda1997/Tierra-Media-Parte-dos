package model;

public class PromocionAbsoluta extends Promocion {

	

	private static int id;
	
	
	


	public PromocionAbsoluta(int id, String nombre, int atraccion1_id, int atraccion2_id,  double tiempo, double costo,
			int tipo_id) {
		super(id, nombre, atraccion1_id, atraccion2_id, tiempo, costo, tipo_id);
		
	}
	
	public PromocionAbsoluta(String nombre, int atraccion1_id, int atraccion2_id,  double tiempo, double costo,
			int tipo_id) {
		super(id, nombre, atraccion1_id, atraccion2_id, tiempo, costo, tipo_id);
		
	}
	



	@Override
	public String toString() {
		return " id: " + super.getId() + " Nombre: " + super.getNombre() + " atracción 1 ID: " + super.getAtraccion1_id() +
				" atracción 2 ID: " + super.getAtraccion2_id()  + "Tipo id : " + super.getTipo_id()
				+ " costo: " + super.getCosto();

	}

	
}
