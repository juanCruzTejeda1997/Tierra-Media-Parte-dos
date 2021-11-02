package model;

public class PromocionAxB extends Promocion{
	
	private int atraccion_gratis_id;
	private static int id;
	
	
	public PromocionAxB(int id, String nombre, int atraccion1_id, int atraccion2_id, double tiempo, double costo,
			int tipo_id, int cupo, int atraccion_gratis_id) {
		super(id, nombre, atraccion1_id, atraccion2_id, tiempo, costo, tipo_id, cupo);
		this.atraccion_gratis_id = atraccion_gratis_id;
	}

	public PromocionAxB(String nombre, int atraccion1_id, int atraccion2_id, double tiempo, double costo,
			int tipo_id, int cupo, int atraccion_gratis_id) {
		super(nombre, atraccion1_id, atraccion2_id, tiempo, costo, tipo_id, cupo);
		this.atraccion_gratis_id = atraccion_gratis_id;
	}

	public PromocionAxB(String nombre, int atraccion1_id, int atraccion2_id, double tiempo, double costo, int tipo_id,
			 int atraccion_gratis_id) {
		super(nombre, atraccion1_id, atraccion2_id, tiempo, costo, tipo_id);
		this.atraccion_gratis_id = atraccion_gratis_id;
	}

	public PromocionAxB(int id, String nombre, int atraccion1_id, int atraccion2_id, int atraccion_gratis_id,
			double tiempo, double costo, int tipo_id, int cupo) {
		super(id, nombre, atraccion1_id, atraccion2_id, tiempo, costo, tipo_id, cupo);
		this.atraccion_gratis_id = atraccion_gratis_id;
	}

	public PromocionAxB(String nombre, int atraccion1_id, int atraccion2_id, int atraccion_gratis_id, double tiempo,
			double costo, int tipo_id, int cupo) {
		super(id, nombre, atraccion1_id, atraccion2_id, tiempo, costo, tipo_id, cupo);
		this.atraccion_gratis_id = atraccion_gratis_id;
	}

	public PromocionAxB(int id, String nombre, Atraccion atraccion1, Atraccion atraccion2, Atraccion atraccion_gratis,
			double tiempo, double costo, tipo tipo, int cupo) {
		super(id, nombre, atraccion1, atraccion2, tiempo, costo, tipo, cupo);
		this.atraccion_gratis = atraccion_gratis;
	}
	
	public PromocionAxB(String nombre, Atraccion atraccion1, Atraccion atraccion2, Atraccion atraccion_gratis) {
		super(nombre, atraccion1, atraccion2);
		validarPromocionAxB(atraccion1,atraccion_gratis);
	}
	
	public int getAtraccion_gratis_id() {
		return atraccion_gratis_id;
	}

	public Atraccion getAtraccion_gratis() {
		return atraccion_gratis;
	}
	
	@Override
	public int getCupo() {
		return cupo;
	}
	
	public void setCupo(int cupo) {
		this.cupo-=cupo;
	}

	public double calcularCosto() {
		return atraccion1.getCosto() + atraccion2.getCosto();
	}
	
	public double calcularTiempo() {		
		return  atraccion1.getTiempo() + atraccion2.getTiempo() + atraccion_gratis.getTiempo();
	}

	public int calcularCupo() {
		return  Math.min(Math.min(atraccion1.getCupo(),atraccion2.getCupo()),atraccion_gratis.getCupo());
	}

	@Override
	public String toString() {
		if (this.tipo != null) {
			return "| ID = " + super.getId() + "| NOMBRE = " + super.getNombre() + "| ATRACCION1 NOMBRE = "
					+ this.getAtraccion1().getNombre() + "| ATRACCION2 NOMBRE =  " + this.getAtraccion2().getNombre()
					+ "| ATRACCION GRATIS NOMBRE =  " + this.getAtraccion_gratis().getNombre() + "|TIPO TIPO = "
					+ super.getTipo() + "| COSTO = " + super.getCosto()+ " CUPO =" + super.getCupo();
		}
		return "| ID =  " + super.getId() + " | NOMBRE = " + super.getNombre() + "| ATRACCION1 ID = "
				+ super.getAtraccion1_id() + "| ATRACCION 2 ID = " + super.getAtraccion2_id()
				+ "| ATRACCION GRATIS ID =  " + this.getAtraccion_gratis_id() + "|TIPO TIPO =  " + super.getTipo_id()
				+ "| COSTO =" + super.getCosto()+ " CUPO =" + super.getCupo();
	}

	@Override
	public void restarCupo() {
		super.atraccion1.restarCupo();
		super.atraccion2.restarCupo();
		super.atraccion_gratis.restarCupo();
	}

	@Override
	protected boolean esPromo() {
		return true;
	}
	private void validarPromocionAxB(Atraccion atraccion1, Atraccion atraccion_gratis) {
		try {
			if (atraccion1.getTipo() != atraccion_gratis.getTipo()) {
				throw new TipoAtraccionException ("La atracción gratis debe ser del mismo tipo que las otras atracciones");
			}
			this.atraccion_gratis = atraccion_gratis;
		}
		catch (TipoAtraccionException tae){
            System.err.println(tae.getMessage());
        }	
	}

	@Override
	public boolean contiene(Producto producto) {
		return super.contiene(producto) || producto.contiene(atraccion_gratis);
	}
}
