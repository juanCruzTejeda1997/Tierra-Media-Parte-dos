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
	
	public double calcularCosto () {
		
		return Math.round((atraccion1.getCosto()+ atraccion2.getCosto()) * (descuento / 100));
	}
	
public double calcularTiempo () {
		
	return  atraccion1.getTiempo() + atraccion2.getTiempo();
	}

public int calcularCupo() {
	return Math.min(atraccion1.getCupo(), atraccion2.getCupo());
	
}

	@Override
	public String toString() {
		if (this.tipo != null) {
			return "| ID =  " + super.getId() + " NOMBRE = " + super.getNombre() + " ATRACCION1 NOMBRE = "
					+ this.getAtraccion1().getNombre() + " ATRACCION2 NOMBRE = " + this.getAtraccion2().getNombre() +"TIEMPO = " + super.getTiempo()
					+ " DESCUENTO =  " + getDescuento() + " COSTO = "+ super.getCosto()+" TIPO TIPO = " 
					+ super.getTipo() +  " CUPO =" + super.getCupo();
		}
		return "| ID = " + super.getId() + " NOMBRE = " + super.getNombre() + "ATRACCION1 ID = "
				+ super.getAtraccion1_id() + " ATRACCION2 ID =  " + super.getAtraccion2_id() + "TIEMPO = " + super.getTiempo()+ " DESCUENTO =  "
				+ getDescuento() + " COSTO = " + super.getCosto() + " TIPO ID =" + super.getTipo_id() + " CUPO =" + super.getCupo();

	}

	public double getDescuento() {
		return descuento;
	}
	
	public int sumarCupos() {
		return this.cupo = atraccion1.getCupo() + atraccion2.getCupo();
	}

	@Override
	public void restarCupo() {
		super.atraccion1.restarCupo();
		super.atraccion2.restarCupo();
		
		
	}
	
	public void verificarCupos() throws Exception {
		if(this.atraccion1.tieneCupo()&& this.atraccion2.tieneCupo()) {
			cupo = this.atraccion1.getCupo()+this.atraccion2.getCupo();
		}
		else {
			throw new Exception ("una de las atracciones no cuenta con el cupo suficiente");
		}
	}

	@Override
	protected boolean esPromo() {
		// TODO Auto-generated method stub
		return true;
	}
	
	public void setCupo(int cupo) {
		this.cupo-=cupo;
	}

	
	
	


}

/*
 * public ArrayList<Atraccion> getAtracciones() throws SQLException { String sql
 * = "SELECT ID FROM PROMOCION WHERE NOMBRE = ?"; Connection conn =
 * ConnectionProvider.getConnection(); PreparedStatement statement =
 * conn.prepareStatement(sql); statement.setString(1, this.getNombre());
 * ResultSet resultados = statement.executeQuery(); resultados.next(); int row =
 * resultados.getInt("ID");
 * 
 * sql = "SELECT * FROM ATRACCION_PROMOCION WHERE PROMOCION_ID = ?"; conn =
 * ConnectionProvider.getConnection(); statement = conn.prepareStatement(sql);
 * statement.setInt(1, row); resultados = statement.executeQuery();
 * 
 * ArrayList<Integer> ids = new ArrayList<Integer>(); while (resultados.next())
 * { ids.add(resultados.getInt("ID")); }
 * 
 * for (int id : ids) { sql = "SELECT * FROM atraccion WHERE ID = ?"; conn =
 * ConnectionProvider.getConnection(); statement = conn.prepareStatement(sql);
 * statement.setInt(1, id); resultados = statement.executeQuery();
 * atracciones_promocion.add(new Atraccion(resultados.getString(2),
 * resultados.getInt(3), resultados.getDouble(4), resultados.getDouble(5),
 * resultados.getInt(6))); }
 * 
 * resultados.close(); return atracciones_promocion; }
 * 
 * public Double calcularPromocion() { double total =
 * (atracciones_promocion.get(0).getCosto() +
 * atracciones_promocion.get(1).getCosto()) * this.descuento; return total; }
 */
