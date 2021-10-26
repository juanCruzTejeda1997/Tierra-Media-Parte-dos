package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import jdbc.ConnectionProvider;
import model.Atraccion;

public class AtraccionDAO {
	public int insert(Atraccion atraccion) throws SQLException {
		String sql = "INSERT INTO ATRACCION (NOMBRE, TIPO_ID, COSTO, TIEMPO, CUPO) VALUES (?, ?, ?, ?, ?)";
		// String nombre, int tipo, double costo, double tiempo,  int cupo
		Connection conn = ConnectionProvider.getConnection();

		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setString(1, atraccion.getNombre());
		statement.setInt(2, atraccion.getTipo());
		statement.setDouble(3, atraccion.getCosto());
		statement.setDouble(4, atraccion.getTiempo());
		statement.setInt(5, atraccion.getCupo());
		int rows = statement.executeUpdate();

		return rows;
	}
	
	public int update(Atraccion atraccion) throws SQLException {
		String sql = "UPDATE ATRACCION SET CUPO = ? WHERE NOMBRE = ?";
		Connection conn = ConnectionProvider.getConnection();

		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setInt(1, atraccion.getCupo());
		statement.setString(2, atraccion.getNombre());
		int rows = statement.executeUpdate();

		return rows;
	}

	public List<Atraccion> findAll() throws SQLException {
		String sql = "SELECT * FROM ATRACCION";
		Connection conn = ConnectionProvider.getConnection();
		PreparedStatement statement = conn.prepareStatement(sql);
		ResultSet resultados = statement.executeQuery();

		List<Atraccion> atracciones = new LinkedList<Atraccion>();
		while (resultados.next()) {
			atracciones.add(toAtraccion(resultados));
		}

		return atracciones;
	}

	private Atraccion toAtraccion(ResultSet resultados) throws SQLException {
		return new Atraccion(resultados.getString(2), resultados.getInt(3), resultados.getDouble(4), resultados.getDouble(5), resultados.getInt(6));
		// String nombre, int tipo, double costo, double tiempo,  int cupo
	}
}
