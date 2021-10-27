package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import jdbc.ConnectionProvider;
import model.PromocionPorcentual;

public class PromocionDAOImpl {
	public int insertPromocionPorcentual(PromocionPorcentual promocion) throws SQLException {
		
		String sql = "INSERT INTO promocion (nombre, tipo_promocion_id, tipo_id, descuento, total, atraccion_id) VALUES (?, ?, ?, ?, ?, ?)";
		//String nombre, int tipo, int tipo_promocion, double descuento
		Connection conn = ConnectionProvider.getConnection();
		
		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setString(1, promocion.getNombre());
		statement.setInt(3, promocion.getTipo());
		statement.setInt(2, promocion.getTipoPromocion());
		statement.setDouble(4, promocion.getDescuento());
		statement.setNull(5, java.sql.Types.DOUBLE);
		statement.setNull(6, java.sql.Types.INTEGER);
		int rows = statement.executeUpdate();

		return rows;
	}

	public LinkedList<PromocionPorcentual> findAllPromocionesPorcentuales() throws SQLException {
		String sql = "SELECT * FROM promocion ";
		Connection conn = ConnectionProvider.getConnection();
		PreparedStatement statement = conn.prepareStatement(sql);
		ResultSet resultados = statement.executeQuery();

		LinkedList<PromocionPorcentual> promociones = new LinkedList<PromocionPorcentual>();
		while (resultados.next()) {
			promociones.add(toPromocion(resultados));
		}

		return promociones;
	}

	private PromocionPorcentual toPromocion(ResultSet resultados) throws SQLException {
		return new PromocionPorcentual(resultados.getInt(1), resultados.getString(2), resultados.getInt(3), resultados.getInt(4), resultados.getDouble(5), resultados.getDouble(6), resultados.getInt(7));
		
		// String nombre, int tipo, int tipo_promocion, double descuento
	}
}
