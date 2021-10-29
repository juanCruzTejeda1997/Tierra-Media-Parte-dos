package model;

public class PromocionAxB extends Promocion {

	private int atraccion_gratis_id;
	private static int id;

	public PromocionAxB(int id, String nombre, int atraccion1_id, int atraccion2_id, int atraccion_gratis_id,
			double tiempo, double costo, int tipo_id) {
		super(id, nombre, atraccion1_id, atraccion2_id, tiempo, costo, tipo_id);
		this.atraccion_gratis_id = atraccion_gratis_id;
	}

	public PromocionAxB(String nombre, int atraccion1_id, int atraccion2_id, int atraccion_gratis_id, double tiempo,
			double costo, int tipo_id) {
		super(id, nombre, atraccion1_id, atraccion2_id, tiempo, costo, tipo_id);
		this.atraccion_gratis_id = atraccion_gratis_id;
	}

	public PromocionAxB(int id, String nombre, Atraccion atraccion1, Atraccion atraccion2, Atraccion atraccion_gratis,
			double tiempo, double costo, tipo tipo) {
		super(id, nombre, atraccion1, atraccion2, tiempo, costo, tipo);
		this.atraccion_gratis = atraccion_gratis;
	}
	
	public int getAtraccion_gratis_id() {
		return atraccion_gratis_id;
	}

	public Atraccion getAtraccion_gratis() {
		return atraccion_gratis;
	}


	@Override
	public String toString() {
		if (this.tipo != null) {
			return "| ID = " + super.getId() + "| NOMBRE = " + super.getNombre() + "| ATRACCION1 NOMBRE = "
					+ this.getAtraccion1().getNombre() + "| ATRACCION2 NOMBRE =  " + this.getAtraccion2().getNombre()
					+ "| ATRACCION GRATIS NOMBRE =  " + this.getAtraccion_gratis().getNombre() + "|TIPO TIPO = "
					+ super.getTipo() + "| COSTO = " + super.getCosto();
		}
		return "| ID =  " + super.getId() + " | NOMBRE = " + super.getNombre() + "| ATRACCION1 ID = "
				+ super.getAtraccion1_id() + "| ATRACCION 2 ID = " + super.getAtraccion2_id()
				+ "| ATRACCION GRATIS ID =  " + this.getAtraccion_gratis_id() + "|TIPO TIPO =  " + super.getTipo_id()
				+ "| COSTO =" + super.getCosto();

	}

	
}
