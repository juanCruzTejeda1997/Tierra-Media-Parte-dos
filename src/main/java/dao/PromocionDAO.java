package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import jdbc.ConnectionProvider;
import model.PromocionPorcentual;

public class PromocionDAO {
	public int insertPromocionPorcentual(PromocionPorcentual promocion) throws SQLException {
		
		String sql = "INSERT INTO PROMOCION (NOMBRE, TIPO_ID, TIPO_PROMOCION_ID, DESCUENTO, TOTAL, ATRACCION_ID) VALUES (?, ?, ?, ?, ?, ?)";
		//String nombre, int tipo, int tipo_promocion, double descuento
		Connection conn = ConnectionProvider.getConnection();
		
		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setString(1, promocion.getNombre());
		statement.setInt(2, promocion.getTipo());
		statement.setInt(3, promocion.getTipoPromocion());
		statement.setDouble(4, promocion.getDescuento());
		statement.setNull(5, java.sql.Types.DOUBLE);
		statement.setNull(6, java.sql.Types.INTEGER);
		int rows = statement.executeUpdate();

		return rows;
	}

	public List<PromocionPorcentual> findAll() throws SQLException {
		String sql = "SELECT * FROM PROMOCION";
		Connection conn = ConnectionProvider.getConnection();
		PreparedStatement statement = conn.prepareStatement(sql);
		ResultSet resultados = statement.executeQuery();

		List<PromocionPorcentual> promociones = new LinkedList<PromocionPorcentual>();
		while (resultados.next()) {
			promociones.add(toPromocion(resultados));
		}

		return promociones;
	}

	private PromocionPorcentual toPromocion(ResultSet resultados) throws SQLException {
		return new PromocionPorcentual(resultados.getString(2), resultados.getInt(3), resultados.getInt(4), resultados.getDouble(5));
		// String nombre, int tipo, int tipo_promocion, double descuento
	}
}
