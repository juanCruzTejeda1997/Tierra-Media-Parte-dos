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
	
	public PromocionAbsoluta(int id, String nombre, Atraccion atraccion1, Atraccion atraccion2, double tiempo, double costo,
			tipo tipo) {
		super(id, nombre, atraccion1, atraccion2, tiempo, costo, tipo);
		
	}
	



	@Override
	public String toString() {
		if(this.tipo != null) {
			return "| ID = " + super.getId() + "| NOMBRE =" + super.getNombre() + "| ATRACCION1 NOMBRE = " + this.getAtraccion1().getNombre() +
					"| ATRACCION2 NOMBRE = " + this.getAtraccion2().getNombre() + "| costo: " + super.getCosto() +  " TIPO TIPO = " + super.getTipo();
		}
		return "|| ID = " + super.getId() + " | NOMBRE =" + super.getNombre() + "| ATRACCION1 ID = " + super.getAtraccion1_id() +
				"| ATRACCION2 ID = " + super.getAtraccion2_id()  + "| COSTO " + super.getCosto() + "| TIPO ID = : " + super.getTipo_id();

	}

	
}
