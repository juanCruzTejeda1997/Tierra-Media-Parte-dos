package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import jdbc.ConnectionProvider;
import model.Promocion;
import model.PromocionPorcentual;

public class PromocionPorcentualDAOImpl implements PromocionDAO {
	public int insertPromocionPorcentual(PromocionPorcentual promocion) throws SQLException {
		
	
		String sql = "INSERT INTO Promocion_Porcentual (nombre, atraccion1_id, atraccion2_id, tiempo, descuento, costo, tipo_id) VALUES (?, ?, ?, ?, ?, ?, ?)";
		
		Connection conn = ConnectionProvider.getConnection();
		
		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setString(1, promocion.getNombre());
		statement.setInt(2, promocion.getAtraccion1_id());
		statement.setInt(3, promocion.getAtraccion2_id());
		statement.setDouble(4, promocion.getTiempo());
		statement.setDouble(5, promocion.getDescuento());
		statement.setDouble(6, promocion.getCosto());
		statement.setInt(7, promocion.getTipo_id());
		int rows = statement.executeUpdate();

		return rows;
	}

	public LinkedList<PromocionPorcentual> findAllPromocionesPorcentuales() throws SQLException {
		String sql = "SELECT * FROM Promocion_Porcentual ";
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
		return new PromocionPorcentual(resultados.getInt(1), resultados.getString(2), resultados.getInt(3), resultados.getInt(4), 
				resultados.getDouble(5), resultados.getDouble(6), resultados.getDouble(7), resultados.getInt(8));
		
		// String nombre, int tipo, int tipo_promocion, double descuento
	}

	public List<Promocion> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public int countAll() {
		// TODO Auto-generated method stub
		return 0;
	}



	public int update(Promocion t) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int delete(Promocion t) {
		// TODO Auto-generated method stub
		return 0;
	}

	public Promocion buscarPromocionPorNombre(String nombre) {
		// TODO Auto-generated method stub
		return null;
	}

	public int insert(Promocion t) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int insertPromocionPorcentual(Promocion t) {
		// TODO Auto-generated method stub
		return 0;
	}
}
