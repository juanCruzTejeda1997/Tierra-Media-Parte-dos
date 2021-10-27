package model;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import jdbc.ConnectionProvider;

public class PromocionPorcentual extends Promocion{

	private double descuento;
	private int tipo_promocion_id = 1;
	private int id;
	private int tipo_id;
	private int atraccion_id;
	
	
	public PromocionPorcentual(int id, String nombre, int tipo_promocion_id, int tipo_id, double descuento, double total, int atraccion_id) throws SQLException {
		super(nombre, tipo_id, tipo_promocion_id);
		this.descuento = descuento;
		}
	
	public Double getDescuento() {
		return this.descuento;
	}
	public int getAtraccion_id() {
		return this.atraccion_id;
	}
	public int getTipo_id() {
		return this.tipo_id;
	}

	public int getTipo_promocion_id1() {
		return tipo_promocion_id;
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	/*public ArrayList<Atraccion> getAtracciones() throws SQLException {
		String sql = "SELECT ID FROM PROMOCION WHERE NOMBRE = ?";
		Connection conn = ConnectionProvider.getConnection();
		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setString(1, this.getNombre());
		ResultSet resultados = statement.executeQuery();
		resultados.next();
		int row = resultados.getInt("ID");
		
		sql = "SELECT * FROM ATRACCION_PROMOCION WHERE PROMOCION_ID = ?";
		conn = ConnectionProvider.getConnection();
		statement = conn.prepareStatement(sql);
		statement.setInt(1, row);
		resultados = statement.executeQuery();

		ArrayList<Integer> ids = new ArrayList<Integer>();
		while (resultados.next()) {
			ids.add(resultados.getInt("ID"));
		}
		
		for (int id : ids) {
			sql = "SELECT * FROM atraccion WHERE ID = ?";
			conn = ConnectionProvider.getConnection();
			statement = conn.prepareStatement(sql);
			statement.setInt(1, id);
			resultados = statement.executeQuery();
			atracciones_promocion.add(new Atraccion(resultados.getString(2), resultados.getInt(3), resultados.getDouble(4), resultados.getDouble(5), resultados.getInt(6)));
		}
			
		resultados.close();
		return atracciones_promocion;
	}
	
	public Double calcularPromocion() {
		double total = (atracciones_promocion.get(0).getCosto() + atracciones_promocion.get(1).getCosto()) * this.descuento;
		return total;
	}
	*/
	@Override
	public String toString() {
		return super.getNombre() + " : " + " id promocion :" +  getTipo_promocion_id1() + " tipo id :" + getTipo_id()+ " tipo descuento: "+ getDescuento()+ " total " + getTotal()+ " id atracion:"+ getAtraccion_id();
		
	}



	

	
}

