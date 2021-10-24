package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import jdbc.ConnectionProvider;
import model.Promocion;


public class PromocionDAOImpl implements PromocionDAO{
	
	public int insert(Promocion promocion) {
		try {
			String sql = "INSERT INTO PROMOCION (NOMBRE, TIPO_PROMOCION_ID, TIPO_ID, DESCUENTO, TOTAL) VALUES (?, ?, ?, ?, ?)";
			Connection conn = ConnectionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(2, promocion.getNombre());
			statement.setInt(3, promocion.getTipoPromocion());
			statement.setInt(4, promocion.getTipoDeAtraccion());
			statement.setDouble(5, promocion.getDescuento());
			statement.setDouble(6, promocion.getTotal());
			int rows = statement.executeUpdate();

			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	public int update(Promocion promocion) {
		try {
			String sql = "UPDATE PROMOCION SET TIPO_PROMOCION_ID = ?, TIPO_ID = ?, DESCUENTO = ?, TOTAL = ? WHERE NOMBRE = ?";
			Connection conn = ConnectionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(3, promocion.getTipoPromocion());
			statement.setInt(4, promocion.getTipoDeAtraccion());
			statement.setDouble(5, promocion.getDescuento());
			statement.setDouble(6, promocion.getTotal());
			int rows = statement.executeUpdate();

			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	public int delete(Promocion promocion) {
		try {
			String sql = "DELETE FROM PROMOCION WHERE NOMBRE = ?";
			Connection conn = ConnectionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(2, promocion.getNombre());
			int rows = statement.executeUpdate();

			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	public Promocion buscarPromocionPorNombre(String nombre) {
		try {
			String sql = "SELECT * FROM PROMOCION WHERE NOMBRE = ?";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(2, nombre);
			ResultSet resultados = statement.executeQuery();

			Promocion promocion = null;

			if (resultados.next()) {
				promocion = toPromocion(resultados);
			}

			return promocion;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	public int countAll() {
		try {
			String sql = "SELECT COUNT(1) AS TOTAL FROM PROMOCION";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet resultados = statement.executeQuery();

			resultados.next();
			int total = resultados.getInt("TOTAL");

			return total;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	public List<Promocion> findAll() {
		try {
			String sql = "SELECT * FROM PROMOCION";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet resultados = statement.executeQuery();

			List<Promocion> promociones = new LinkedList<Promocion>();
			while (resultados.next()) {
				promociones.add(toPromocion(resultados));
			}

			return promociones;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	private Promocion toPromocion(ResultSet resultados) throws SQLException {
		return new Promocion(resultados.getString(2), resultados.getInt(3), resultados.getInt(4), resultados.getDouble(5), resultados.getDouble(6));
	}

}
