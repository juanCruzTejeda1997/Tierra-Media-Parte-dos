package model;

public class PromocionAbsoluta extends Promocion {


	private static int id;
	

	public PromocionAbsoluta(int id, String nombre, int atraccion1_id, int atraccion2_id,  double tiempo, double costo,
			int tipo_id, int cupo) {
		super(id, nombre, atraccion1_id, atraccion2_id, tiempo, costo, tipo_id, cupo);
		
	}
	
	public PromocionAbsoluta(String nombre, int atraccion1_id, int atraccion2_id,  double tiempo, double costo,
			int tipo_id, int cupo) {
		super(id, nombre, atraccion1_id, atraccion2_id, tiempo, costo, tipo_id, cupo);
		
	}
	
	public PromocionAbsoluta(int id, String nombre, Atraccion atraccion1, Atraccion atraccion2, double tiempo, double costo,
			tipo tipo, int cupo) {
		super(id, nombre, atraccion1, atraccion2, tiempo, costo, tipo, cupo);
		
	}
	

	public double calcularTiempo () {
			
		return  atraccion1.getTiempo() + atraccion2.getTiempo();
		}

	public int calcularCupo() {
		return  Math.min(atraccion1.getCupo(),atraccion2.getCupo());
		
	}
	



	@Override
	public String toString() {
		if(this.tipo != null) {
			return "| NOMBRE =" + super.getNombre() + " | ATRACCION1 NOMBRE = " + this.getAtraccion1().getNombre() +
					" | ATRACCION2 NOMBRE = " + this.getAtraccion2().getNombre() + " | COSTO = " + super.getCosto() +  " | TIPO = " + super.getTipo() + " | CUPO =" + super.getCupo();
		}
		return "| NOMBRE =" + super.getNombre() + " | ATRACCION1 ID = " + super.getAtraccion1_id() +
				" | ATRACCION2 ID = " + super.getAtraccion2_id()  + " | COSTO  = " + super.getCosto() + " | TIPO ID = : " + super.getTipo_id() + " | CUPO =" + super.getCupo();

	}
	
	public void setCupo(int cupo) {
		this.cupo-=cupo;
	}

	@Override
	public void restarCupo() {
		super.atraccion1.restarCupo();
		super.atraccion2.restarCupo();
		
	}

	@Override
	protected boolean esPromo() {
		return true;
	}




}
