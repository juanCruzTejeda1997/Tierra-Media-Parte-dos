package DAOTests;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.After;
import org.junit.Test;

import DAO.DAOFactory;
import DAO.PromocionAbsolutaDAO;
import DAO.PromocionAxBDAO;
import DAO.PromocionPorcentualDAO;
import jdbc.ConnectionProvider;
import model.PromocionAbsoluta;
import model.PromocionAxB;
import model.PromocionPorcentual;

public class InsertarPromocionesDAOTest {

	@After
	public void tearDown() throws Exception {
		String sql = "DELETE FROM PROMOCIONAXB";
		Connection conn = ConnectionProvider.getConnection();

		PreparedStatement statement = conn.prepareStatement(sql);
		int rows = statement.executeUpdate();
		
		sql = "DELETE FROM PROMOCION_ABSOLUTA";
		conn = ConnectionProvider.getConnection();

		statement = conn.prepareStatement(sql);
		rows = statement.executeUpdate();
		
		sql = "DELETE FROM PROMOCION_PORCENTUAL";
		conn = ConnectionProvider.getConnection();

		statement = conn.prepareStatement(sql);
		rows = statement.executeUpdate();
	}

	@Test
	public void insertarAxB() throws SQLException {
		PromocionAxBDAO nuevaAxB = DAOFactory.getPromocionesAxBs();
		nuevaAxB.insert(new PromocionAxB("pack Paisaje", 2, 5, 7, 0.00, 0.00, 3, 5));
		nuevaAxB.insert(new PromocionAxB("pack Aventura + 1 gratis", 1, 4, 8,0.00,0.00, 1, 5));
		
		Connection conn = ConnectionProvider.getConnection();
		String sql = "SELECT COUNT(id) AS TOTAL FROM PROMOCIONAXB";
		PreparedStatement statement = conn.prepareStatement(sql);
		ResultSet resultados = statement.executeQuery();
		resultados.next();
		int total = resultados.getInt("TOTAL");
		
		assertEquals(2, total);
	}
	
	@Test
	public void insertarAbsoluta() throws SQLException {
		PromocionAbsolutaDAO nuevaAbs = DAOFactory.getPromocionesAbsolutas();
		nuevaAbs.insert(new PromocionAbsoluta("Pack Degustacion", 6, 3, 0.00, 36.00, 2, 2));
		nuevaAbs.insert(new PromocionAbsoluta("Pack Degustacion1", 6, 3, 0.00, 36.00, 2, 2));
		
		Connection conn = ConnectionProvider.getConnection();
		String sql = "SELECT COUNT(id) AS TOTAL FROM PROMOCION_ABSOLUTA";
		PreparedStatement statement = conn.prepareStatement(sql);
		ResultSet resultados = statement.executeQuery();
		resultados.next();
		int total = resultados.getInt("TOTAL");
		
		assertEquals(2, total);
	}
	
	@Test
	public void insertarPorcentual() throws SQLException {
		PromocionPorcentualDAO nuevaPorcentual = DAOFactory.getPromocionesPorcentuales();
		nuevaPorcentual.insert(new PromocionPorcentual("pack Aventura", 8, 3, 0, 20.00, 0, 1, 5)); 
		nuevaPorcentual.insert(new PromocionPorcentual("pack Aventura Mediterranea", 8, 3, 0, 20.00, 0, 1, 5));
		
		Connection conn = ConnectionProvider.getConnection();
		String sql = "SELECT COUNT(id) AS TOTAL FROM PROMOCION_PORCENTUAL";
		PreparedStatement statement = conn.prepareStatement(sql);
		ResultSet resultados = statement.executeQuery();
		resultados.next();
		int total = resultados.getInt("TOTAL");
		
		assertEquals(2, total);
	}
}
