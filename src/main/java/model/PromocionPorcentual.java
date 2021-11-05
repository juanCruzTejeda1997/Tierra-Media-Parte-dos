package model;

import java.util.ArrayList;

public class PromocionPorcentual extends Promocion {

	private double descuento;

	private ArrayList<Atraccion> atraccionesPromocion = new ArrayList<Atraccion>();

	private static int id;

	public PromocionPorcentual(int id, String nombre, int atraccion1_id, int atraccion2_id, double tiempo, double costo,
			int tipo_id, int cupo, ArrayList<Atraccion> atraccionesPromocion) {
		super(id, nombre, atraccion1_id, atraccion2_id, tiempo, costo, tipo_id, cupo);
		this.atraccionesPromocion = atraccionesPromocion;
	}

	public PromocionPorcentual(int id, String nombre, int atraccion1_id, int atraccion2_id, double tiempo,
			double descuento, double costo, int tipo_id, int cupo) {
		super(id, nombre, atraccion1_id, atraccion2_id, tiempo, costo, tipo_id, cupo);
		this.descuento = descuento;
	}

	public PromocionPorcentual(String nombre, int atraccion1_id, int atraccion2_id, double tiempo, double descuento,
			double costo, int tipo_id, int cupo) {
		super(id, nombre, atraccion1_id, atraccion2_id, tiempo, costo, tipo_id, cupo);
		this.descuento = descuento;
	}

	public PromocionPorcentual(int id, String nombre, Atraccion atraccion1, Atraccion atraccion2, double tiempo,
			double descuento, double costo, tipo tipo, int cupo) {
		super(id, nombre, atraccion1, atraccion2, tiempo, costo, tipo, cupo);
		this.descuento = descuento;
	}

	public double calcularCosto() {

		return Math.round((atraccion1.getCosto() + atraccion2.getCosto()) * (descuento));
	}
	public double getCosto() {
		return this.costo;
	}

	public double calcularTiempo() {

		return atraccion1.getTiempo() + atraccion2.getTiempo();
	}
	
	public double getTiempo() {
		return this.tiempo;
	}

	public double getDescuento() {
		return descuento;
	}

	@Override
	public void restarCupo() {
		super.atraccion1.restarCupo();
		super.atraccion2.restarCupo();

	}

	public int getCupo() {
		return Math.min(super.atraccion1.getCupo(), super.atraccion2.getCupo());
	}
	public int dbgetCupo() {
		return this.cupo;
	}

	@Override
	protected boolean esPromo() {
		// TODO Auto-generated method stub
		return true;
	}

	public void setCupo(int cupo) {
		this.cupo -= cupo;
	}

	public ArrayList<Atraccion> getAtraccionesPromocion() {
		return atraccionesPromocion;
	}

	public void setAtraccionesPromocion(ArrayList<Atraccion> atraccionesPromocion) {
		this.atraccionesPromocion = atraccionesPromocion;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((atraccionesPromocion == null) ? 0 : atraccionesPromocion.hashCode());
		long temp;
		temp = Double.doubleToLongBits(descuento);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		PromocionPorcentual other = (PromocionPorcentual) obj;
		if (atraccionesPromocion == null) {
			if (other.atraccionesPromocion != null)
				return false;
		} else if (!atraccionesPromocion.equals(other.atraccionesPromocion))
			return false;
		if (Double.doubleToLongBits(descuento) != Double.doubleToLongBits(other.descuento))
			return false;
		return true;
	}

	/*
	 * public void verificarCupos() throws Exception {
	 * if(this.atraccion1.tieneCupo()&& this.atraccion2.tieneCupo()) { cupo =
	 * this.atraccion1.getCupo()+this.atraccion2.getCupo(); } else { throw new
	 * Exception ("una de las atracciones no cuenta con el cupo suficiente"); } }
	 */

	@Override
	public String toString() {
		if (this.tipo != null) {
			return "| ID =  " + super.getId() + " NOMBRE = " + super.getNombre() + " ATRACCION1 NOMBRE = "
					+ this.getAtraccion1().getNombre() + " ATRACCION2 NOMBRE = " + this.getAtraccion2().getNombre()
					+ "TIEMPO = " + super.getTiempo() + " DESCUENTO =  " + getDescuento() + " COSTO = "
					+ super.getCosto() + " TIPO TIPO = " + super.getTipo() + " CUPO =" + super.getCupo();
		}
		return "| ID = " + super.getId() + " NOMBRE = " + super.getNombre() + "ATRACCION1 ID = "
				+ super.getAtraccion1_id() + " ATRACCION2 ID =  " + super.getAtraccion2_id() + "TIEMPO = "
				+ super.getTiempo() + " DESCUENTO =  " + getDescuento() + " COSTO = " + super.getCosto() + " TIPO ID ="
				+ super.getTipo_id() + " CUPO =" + super.getCupo();

	}

}
