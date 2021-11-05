package DAOTests;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.After;
import org.junit.Test;

import DAO.AtraccionDAO;
import DAO.DAOFactory;
import jdbc.ConnectionProvider;
import model.Atraccion;

public class InsertarAtraccionesDAOTests {

	@After
	public void tearDown() throws Exception {
		String sql = "DELETE FROM ATRACCION";
		Connection conn = ConnectionProvider.getConnection();

		PreparedStatement statement = conn.prepareStatement(sql);
		int rows = statement.executeUpdate();
	}

	@Test
	public void test() throws SQLException {
		AtraccionDAO atrcc = DAOFactory.getAtraccionDAO(); 
		atrcc.insert(new Atraccion("Moria", 10.00, 2.00, 6, 1)); atrcc.insert(new
		Atraccion("Minas Tirith", 5.00, 2.50, 25, 3)); atrcc.insert(new
		Atraccion("La Comarca", 3.00, 6.5, 150, 2)); atrcc.insert(new
		Atraccion("Mordor", 25.00, 3.00, 4, 1)); atrcc.insert(new
		Atraccion("Abismo de Helm", 5.00, 2.00, 15, 3)); atrcc.insert(new
		Atraccion("Lothórien", 35.00, 1.00, 30, 2)); atrcc.insert(new
		Atraccion("Erebor", 12.00, 3.00, 32, 3)); atrcc.insert(new
		Atraccion("Bosque Negro", 3.00, 4.00, 12, 1));
		
		Connection conn = ConnectionProvider.getConnection();
		String sql = "SELECT COUNT(id) AS TOTAL FROM ATRACCION";
		PreparedStatement statement = conn.prepareStatement(sql);
		ResultSet resultados = statement.executeQuery();
		resultados.next();
		int total = resultados.getInt("TOTAL");
		
		assertEquals(8, total);
	}

}
