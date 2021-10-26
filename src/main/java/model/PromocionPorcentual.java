package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jdbc.ConnectionProvider;

public class PromocionPorcentual extends Promocion{

	private double descuento;
	List<Atraccion> atracciones_promocion;
	
	public PromocionPorcentual(String nombre, int tipo, int tipo_promocion, double descuento) throws SQLException {
		super(nombre, tipo, tipo_promocion);
		this.descuento = descuento;
		atracciones_promocion = new ArrayList<Atraccion>();
	}
	
	public Double getDescuento() {
		return this.descuento;
	}
	
	public List<Atraccion> getAtracciones() throws SQLException {
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

		List<Integer> ids = new ArrayList<Integer>();
		while (resultados.next()) {
			ids.add(resultados.getInt("ID"));
		}
		
		for (int id : ids) {
			sql = "SELECT * FROM ATRACCIONES WHERE ID = ?";
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
	
	@Override
	public String toString() {
		return super.getNombre() + " : " + getAtracciones().get(0).getNombre() + " y " + getAtracciones().get(1).getNombre() + " con un descuento del " + this.descuento * 100 + " %"+" por lo que el costo total es de "+ this.calcularPromocion() + " monedas";
	}
}
