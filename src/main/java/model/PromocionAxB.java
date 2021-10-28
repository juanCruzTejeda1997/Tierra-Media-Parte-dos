package model;

public class PromocionAxB extends Promocion {
	
	private int atraccion_gratis_id;

	

	public PromocionAxB( String nombre, int atraccion1_id, int atraccion2_id, int atraccion_gratis_id, double tiempo, double costo,
			int tipo_id) {
		super(nombre, atraccion1_id, atraccion2_id, tiempo, costo, tipo_id);
		this.atraccion_gratis_id = atraccion_gratis_id;
		// TODO Auto-generated constructor stub
	}
	
	public PromocionAxB( int id, String nombre, int atraccion1_id, int atraccion2_id, int atraccion_gratis_id, double tiempo, double costo,
			int tipo_id) {
		super(nombre, atraccion1_id, atraccion2_id, tiempo, costo, tipo_id);
		this.atraccion_gratis_id = atraccion_gratis_id;
		// TODO Auto-generated constructor stub
	}
	


	public int getAtraccion_gratis_id() {
		return this.atraccion_gratis_id;
	}

	@Override
	public String toString() {
		return "PromocionAxB Id()=" + getId() + "[Nombre= " + super.getNombre() + ", Atraccion1_id()=" + super.getAtraccion1_id()
				+ ", Atraccion2_id()=" + super.getAtraccion2_id() + ", Atraccion_gratis_id()= " + this.getAtraccion_gratis_id() +
				" Tiempo()=" + super.getTiempo() +", Costo()="+ getCosto() + ", Tipo_id()=" + getTipo_id();
	}
	

}
