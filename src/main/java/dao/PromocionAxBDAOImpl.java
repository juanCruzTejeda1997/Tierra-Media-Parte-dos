package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import jdbc.ConnectionProvider;
import model.Promocion;
import model.PromocionAxB;


public class PromocionAxBDAOImpl implements PromocionDAO {
	public int insertPromocionAxB(PromocionAxB promocion) throws SQLException {
		
		
		String sql = "INSERT INTO PromocionAxB (nombre, atraccion1_id, atraccion2_id, atraccion_gratis_id, tiempo, costo, tipo_id) VALUES (?, ?, ?, ?, ?, ?, ?)";
		
		Connection conn = ConnectionProvider.getConnection();
		
		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setString(1, promocion.getNombre());
		statement.setInt(2, promocion.getAtraccion1_id());
		statement.setInt(3, promocion.getAtraccion2_id());
		statement.setInt(4, promocion.getAtraccion_gratis_id());
		statement.setDouble(5, promocion.getTiempo());
		statement.setDouble(6, promocion.getCosto());
		statement.setInt(7, promocion.getTipo_id());
		int rows = statement.executeUpdate();

		return rows;
	}

	public LinkedList<PromocionAxB> findAllPromocionesAxB() throws SQLException {
		String sql = "SELECT * FROM PromocionAxB ";
		Connection conn = ConnectionProvider.getConnection();
		PreparedStatement statement = conn.prepareStatement(sql);
		ResultSet resultados = statement.executeQuery();

		LinkedList<PromocionAxB> promocionesAxB = new LinkedList<PromocionAxB>();
		while (resultados.next()) {
			promocionesAxB.add(toPromocion(resultados));
		}

		return promocionesAxB;
	}

	private PromocionAxB toPromocion(ResultSet resultados) throws SQLException {
		return new PromocionAxB(resultados.getInt(1), resultados.getString(2), resultados.getInt(3), resultados.getInt(4), 
				resultados.getInt(5), resultados.getDouble(6), resultados.getDouble(7), resultados.getInt(8));
		
	}

	public List<Promocion> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public int countAll() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int insert(Promocion t) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int insertPromocionPorcentual(Promocion t) {
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
		
}
