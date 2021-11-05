package model;

public class PromocionAbsoluta extends Promocion {

	private static int id;

	public PromocionAbsoluta(int id, String nombre, int atraccion1_id, int atraccion2_id, double tiempo, double costo,
			int tipo_id, int cupo) {
		super(id, nombre, atraccion1_id, atraccion2_id, tiempo, costo, tipo_id, cupo);

	}

	public PromocionAbsoluta(String nombre, int atraccion1_id, int atraccion2_id, double tiempo, double costo,
			int tipo_id, int cupo) {
		super(id, nombre, atraccion1_id, atraccion2_id, tiempo, costo, tipo_id, cupo);

	}

	public PromocionAbsoluta(int id, String nombre, Atraccion atraccion1, Atraccion atraccion2, double tiempo,
			double costo, tipo tipo, int cupo) {
		super(id, nombre, atraccion1, atraccion2, tiempo, costo, tipo, cupo);

	}
	
	public double getTiempo() {
		return this.tiempo;
	}
	
	public double calcularTiempo() {
		return this.tiempo = super.atraccion1.getTiempo() + super.atraccion2.getTiempo();
	}


	public int dbgetCupo() {
		return this.cupo;

	}
	
	public int getCupo() {
		return Math.min(super.atraccion1.getCupo(), super.atraccion2.getCupo());
	}

	public void setCupo(int cupo) {
		this.cupo -= cupo;
	}

	@Override
	public void restarCupo() {
		this.atraccion1.restarCupo();
		this.atraccion2.restarCupo();

	}

	@Override
	protected boolean esPromo() {
		return true;
	}

	@Override
	public String toString() {
		if (this.tipo != null) {
			return "| ID = " + super.getId() + " NOMBRE =" + super.getNombre() + " ATRACCION1 NOMBRE = "
					+ this.getAtraccion1().getNombre() + " ATRACCION2 NOMBRE = " + this.getAtraccion2().getNombre()
					+ " TIEMPO = " + super.getTiempo() + " COSTO = " + super.getCosto() + " TIPO TIPO = "
					+ super.getTipo() + " CUPO =" + super.getCupo();
		}
		return "| ID = " + super.getId() + "  NOMBRE =" + super.getNombre() + " ATRACCION1 ID = "
				+ super.getAtraccion1_id() + " ATRACCION2 ID = " + super.getAtraccion2_id() + " TIEMPO = "
				+ super.getTiempo() + " COSTO = " + super.getCosto() + " TIPO ID =  " + super.getTipo_id() + " CUPO ="
				+ super.getCupo();

	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		return true;
	}

}
