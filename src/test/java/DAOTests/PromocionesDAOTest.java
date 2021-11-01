package DAOTests;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import DAO.DAOFactory;
import DAO.PromocionAbsolutaDAO;
import DAO.PromocionAxBDAO;
import DAO.PromocionPorcentualDAO;
import jdbc.ConnectionProvider;
import model.PromocionAbsoluta;
import model.PromocionAxB;
import model.PromocionPorcentual;

public class PromocionesDAOTest {
	PromocionAxBDAO nuevaAxB = DAOFactory.getPromocionesAxBs();
	PromocionAbsolutaDAO nuevaAbs = DAOFactory.getPromocionesAbsolutas();
	PromocionPorcentualDAO nuevaPorcentual = DAOFactory.getPromocionesPorcentuales();

	@Before
	public void setUp() throws Exception {
		nuevaAxB.insert(new PromocionAxB("pack Paisaje", 2, 5, 7, 0.00, 0.00, 3, 5));
		nuevaAxB.insert(new PromocionAxB("pack Aventura + 1 gratis", 1, 4, 8,0.00,0.00, 1, 5));
		
		nuevaAbs.insert(new PromocionAbsoluta("Pack Degustacion", 6, 3, 0.00, 36.00, 2, 2));
		nuevaAbs.insert(new PromocionAbsoluta("Pack Degustacion1", 6, 3, 0.00, 36.00, 2, 2));
		
		nuevaPorcentual.insert(new PromocionPorcentual("pack Aventura", 8, 3, 0, 20.00, 0, 1, 5)); 
		nuevaPorcentual.insert(new PromocionPorcentual("pack Aventura Mediterranea", 8, 3, 0, 20.00, 0, 1, 5));
	}

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
	public void findAllPorcentual() {
		String porcentual = "[| NOMBRE = pack Aventura | ATRACCION1 ID = 8 | ATRACCION2 ID =  3 | TIEMPO = 0.0 | DESCUENTO =  20.0 | COSTO = 0.0 | TIPO ID =1 | CUPO =5, | NOMBRE = pack Aventura Mediterranea | ATRACCION1 ID = 8 | ATRACCION2 ID =  3 | TIEMPO = 0.0 | DESCUENTO =  20.0 | COSTO = 0.0 | TIPO ID =1 | CUPO =5]";
		
		assertEquals(porcentual, nuevaPorcentual.findAll().toString());
	}

	@Test
	public void findAllAxB() {
		String AxB = "[| NOMBRE = pack Paisaje | ATRACCION1 ID = 2 | ATRACCION2 ID = 5 | ATRACCION_GRATIS ID =  7 | TIPO =  3 | COSTO =0.0 | CUPO =5, | NOMBRE = pack Aventura + 1 gratis | ATRACCION1 ID = 1 | ATRACCION2 ID = 4 | ATRACCION_GRATIS ID =  8 | TIPO =  1 | COSTO =0.0 | CUPO =5]";
		
		assertEquals(AxB, nuevaAxB.findAll().toString());
	}
	
	@Test
	public void findAllAbsoluta() {
		String absoluta = "[| NOMBRE =Pack Degustacion | ATRACCION1 ID = 6 | ATRACCION2 ID = 3 | COSTO  = 36.0 | TIPO ID = : 2 | CUPO =2, | NOMBRE =Pack Degustacion1 | ATRACCION1 ID = 6 | ATRACCION2 ID = 3 | COSTO  = 36.0 | TIPO ID = : 2 | CUPO =2]";
		
		assertEquals(absoluta, nuevaAbs.findAll().toString());
	}
	
	//se creó el método update para PromocionPorcentualDAOImpl
	@Test
	public void updatePromocionPorcentual() {
		PromocionPorcentual j = new PromocionPorcentual("pack Aventura", 8, 3, 0, 50.00, 0, 1, 5);
		nuevaPorcentual.update(j);
		
		String porcentual = "[| NOMBRE = pack Aventura | ATRACCION1 ID = 8 | ATRACCION2 ID =  3 | TIEMPO = 0.0 | DESCUENTO =  50.0 | COSTO = 0.0 | TIPO ID =1 | CUPO =5, | NOMBRE = pack Aventura Mediterranea | ATRACCION1 ID = 8 | ATRACCION2 ID =  3 | TIEMPO = 0.0 | DESCUENTO =  20.0 | COSTO = 0.0 | TIPO ID =1 | CUPO =5]";
		
		assertEquals(porcentual, nuevaPorcentual.findAll().toString());
	}
	
	//se creó el método update para PromocionAxBDAOImpl
	@Test
	public void updatePromocionAxB() {
		PromocionAxB j = new PromocionAxB("pack Aventura + 1 gratis", 1, 4, 8,0.00,0.00, 1, 5);
		nuevaAxB.update(j);
		
		String AxB = "[| NOMBRE = pack Paisaje | ATRACCION1 ID = 2 | ATRACCION2 ID = 5 | ATRACCION_GRATIS ID =  7 | TIPO =  3 | COSTO =0.0 | CUPO =5, | NOMBRE = pack Aventura + 1 gratis | ATRACCION1 ID = 1 | ATRACCION2 ID = 4 | ATRACCION_GRATIS ID =  8 | TIPO =  1 | COSTO =0.0 | CUPO =5]";
		
		assertEquals(AxB, nuevaAxB.findAll().toString());
	}
	
	//se creó el método update para PromocionAbsolutaDAOImpl
	@Test
	public void updatePromocionAbsoluta() {
		PromocionAbsoluta j = new PromocionAbsoluta("Pack Degustacion1", 6, 3, 0.00, 40.00, 2, 2);
		nuevaAbs.update(j);
		
		String absoluta = "[| NOMBRE =Pack Degustacion | ATRACCION1 ID = 6 | ATRACCION2 ID = 3 | COSTO  = 36.0 | TIPO ID = : 2 | CUPO =2, | NOMBRE =Pack Degustacion1 | ATRACCION1 ID = 6 | ATRACCION2 ID = 3 | COSTO  = 40.0 | TIPO ID = : 2 | CUPO =2]";
		
		assertEquals(absoluta, nuevaAbs.findAll().toString());
	}
	
	// agregado delete en PromocionPorcentualDAOImpl
	@Test
	public void deletePromocionPorcentual() throws SQLException {
		PromocionPorcentual j = new PromocionPorcentual("pack Aventura", 8, 3, 0, 50.00, 0, 1, 5);
		nuevaPorcentual.delete(j);
		
		Connection conn = ConnectionProvider.getConnection();
		String sql = "SELECT COUNT(id) AS TOTAL FROM Promocion_Porcentual";
		PreparedStatement statement = conn.prepareStatement(sql);
		ResultSet resultados = statement.executeQuery();
		resultados.next();
		int total = resultados.getInt("TOTAL");
		
		String porcentual = "[| NOMBRE = pack Aventura Mediterranea | ATRACCION1 ID = 8 | ATRACCION2 ID =  3 | TIEMPO = 0.0 | DESCUENTO =  20.0 | COSTO = 0.0 | TIPO ID =1 | CUPO =5]";
		
		assertEquals(1, total);
		assertEquals(porcentual, nuevaPorcentual.findAll().toString());
	}
	
	// agregado delete en PromocionAxBDAOImpl
	@Test
	public void deletePromocionAxB() throws SQLException {
		PromocionAxB j = new PromocionAxB("pack Aventura + 1 gratis", 1, 4, 8,0.00,0.00, 1, 5);
		nuevaAxB.delete(j);
		
		Connection conn = ConnectionProvider.getConnection();
		String sql = "SELECT COUNT(id) AS TOTAL FROM PromocionAxB";
		PreparedStatement statement = conn.prepareStatement(sql);
		ResultSet resultados = statement.executeQuery();
		resultados.next();
		int total = resultados.getInt("TOTAL");
		
		String AxB = "[| NOMBRE = pack Paisaje | ATRACCION1 ID = 2 | ATRACCION2 ID = 5 | ATRACCION_GRATIS ID =  7 | TIPO =  3 | COSTO =0.0 | CUPO =5]";
		
		assertEquals(1, total);
		assertEquals(AxB, nuevaAxB.findAll().toString());
	}
	
	// agregado delete en PromocionAbsolutaDAOImpl
	@Test
	public void deletePromocionAbsoluta() throws SQLException {
		PromocionAbsoluta j = new PromocionAbsoluta("Pack Degustacion1", 6, 3, 0.00, 40.00, 2, 2);
		nuevaAbs.delete(j);
		
		Connection conn = ConnectionProvider.getConnection();
		String sql = "SELECT COUNT(id) AS TOTAL FROM Promocion_Absoluta";
		PreparedStatement statement = conn.prepareStatement(sql);
		ResultSet resultados = statement.executeQuery();
		resultados.next();
		int total = resultados.getInt("TOTAL");
		
		String absoluta = "[| NOMBRE =Pack Degustacion | ATRACCION1 ID = 6 | ATRACCION2 ID = 3 | COSTO  = 36.0 | TIPO ID = : 2 | CUPO =2]";
		
		assertEquals(1, total);
		assertEquals(absoluta, nuevaAbs.findAll().toString());
	}
}
