package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import jdbc.ConnectionProvider;
import model.PromocionAbsoluta;


public class PromocionAbsolutaDAOImpl {
public int insertPromocionAbsoluta(PromocionAbsoluta promocion) throws SQLException {
		
		
		String sql = "INSERT INTO Promocion_Absoluta (nombre, atraccion1_id, atraccion2_id, tiempo, costo, tipo_id) VALUES (?, ?, ?, ?, ?, ?)";
		
		Connection conn = ConnectionProvider.getConnection();
		
		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setString(1, promocion.getNombre());
		statement.setInt(2, promocion.getAtraccion1_id());
		statement.setInt(3, promocion.getAtraccion2_id());
		statement.setDouble(4, promocion.getTiempo());
		statement.setDouble(5, promocion.getCosto());
		statement.setInt(6, promocion.getTipo_id());
		int rows = statement.executeUpdate();

		return rows;
	}

	public LinkedList<PromocionAbsoluta> findAllPromocionesAbsolutas() throws SQLException {
		String sql = "SELECT * FROM Promocion_Absoluta ";
		Connection conn = ConnectionProvider.getConnection();
		PreparedStatement statement = conn.prepareStatement(sql);
		ResultSet resultados = statement.executeQuery();

		LinkedList<PromocionAbsoluta> promocionesAbs= new LinkedList<PromocionAbsoluta>();
		while (resultados.next()) {
			promocionesAbs.add(toPromocion(resultados));
		}

		return promocionesAbs;
	}

	private PromocionAbsoluta toPromocion(ResultSet resultados) throws SQLException {
		return new PromocionAbsoluta(resultados.getInt(1), resultados.getString(2), resultados.getInt(3), 
				resultados.getInt(4), resultados.getDouble(5), resultados.getDouble(6), resultados.getInt(7));
		
	}
}
