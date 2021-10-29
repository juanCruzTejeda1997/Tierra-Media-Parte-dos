package model;

public class PromocionAxB extends Promocion {
	
	private int atraccion_gratis_id;

	private static int id;
	
	
	


	public PromocionAxB(int id, String nombre, int atraccion1_id, int atraccion2_id, int atraccion_gratis_id, double tiempo, double costo,
			int tipo_id) {
		super(id, nombre, atraccion1_id, atraccion2_id, tiempo, costo, tipo_id);
		this.atraccion_gratis_id = atraccion_gratis_id;
	}
	
	public PromocionAxB( String nombre, int atraccion1_id, int atraccion2_id, int atraccion_gratis_id, double tiempo, double costo,
			int tipo_id) {
		super(id, nombre, atraccion1_id, atraccion2_id, tiempo, costo, tipo_id);
		this.atraccion_gratis_id = atraccion_gratis_id;
	}

	
	



	@Override
	public String toString() {
		return " id: " + super.getId() + " Nombre: " + super.getNombre() + " atracción 1 ID: " + super.getAtraccion1_id() +
				" atracción 2 ID: " + super.getAtraccion2_id() + " atraccion gratis ID:  " + getAtraccion_gratis_id() + "Tipo id : " + super.getTipo_id()
				+ " costo: " + super.getCosto();

	}

	public int getAtraccion_gratis_id() {
		return atraccion_gratis_id;
	}


	
	}
	
