package DAOTests;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import DAO.AtraccionDAO;
import DAO.DAOFactory;
import jdbc.ConnectionProvider;
import model.Atraccion;
import model.Usuario;

public class AtraccionesDAOTest {
	AtraccionDAO atrcc = DAOFactory.getAtraccionDAO();

	@Before
	public void setUpBeforeClass() throws Exception{
		atrcc.insert(new Atraccion("Moria", 10.00, 2.00, 6, 1)); atrcc.insert(new
		Atraccion("Minas Tirith", 5.00, 2.50, 25, 3)); atrcc.insert(new
		Atraccion("La Comarca", 3.00, 6.5, 150, 2)); atrcc.insert(new
		Atraccion("Mordor", 25.00, 3.00, 4, 1)); atrcc.insert(new
		Atraccion("Abismo de Helm", 5.00, 2.00, 15, 3)); atrcc.insert(new
		Atraccion("Lothórien", 35.00, 1.00, 30, 2)); atrcc.insert(new
		Atraccion("Erebor", 12.00, 3.00, 32, 3)); atrcc.insert(new
		Atraccion("Bosque Negro", 3.00, 4.00, 12, 1));
	}


	@Test
	public void findallAtracciones() {
		String atracciones = "[||NOMBRE = Moria COSTO = 10.0 TIEMPO = 2.0 CUPO = 6 TIPO ID = 1, ||NOMBRE = Minas Tirith COSTO = 5.0 TIEMPO = 2.5 CUPO = 25 TIPO ID = 3, ||NOMBRE = La Comarca COSTO = 3.0 TIEMPO = 6.5 CUPO = 150 TIPO ID = 2, ||NOMBRE = Mordor COSTO = 25.0 TIEMPO = 3.0 CUPO = 4 TIPO ID = 1, ||NOMBRE = Abismo de Helm COSTO = 5.0 TIEMPO = 2.0 CUPO = 15 TIPO ID = 3, ||NOMBRE = Lothórien COSTO = 35.0 TIEMPO = 1.0 CUPO = 30 TIPO ID = 2, ||NOMBRE = Erebor COSTO = 12.0 TIEMPO = 3.0 CUPO = 32 TIPO ID = 3, ||NOMBRE = Bosque Negro COSTO = 3.0 TIEMPO = 4.0 CUPO = 12 TIPO ID = 1]";
		
		assertEquals(atracciones, atrcc.findAll().toString());
	}
	
	// agregado update en AtraccionDAOImpl
	@Test
	public void updateAtraccionesTest() {
		Atraccion j = new Atraccion("Bosque Negro", 5, 4.00, 5, 1); 
		atrcc.update(j);
		
		String atracciones = "[||NOMBRE = Moria COSTO = 10.0 TIEMPO = 2.0 CUPO = 6 TIPO ID = 1, ||NOMBRE = Minas Tirith COSTO = 5.0 TIEMPO = 2.5 CUPO = 25 TIPO ID = 3, ||NOMBRE = La Comarca COSTO = 3.0 TIEMPO = 6.5 CUPO = 150 TIPO ID = 2, ||NOMBRE = Mordor COSTO = 25.0 TIEMPO = 3.0 CUPO = 4 TIPO ID = 1, ||NOMBRE = Abismo de Helm COSTO = 5.0 TIEMPO = 2.0 CUPO = 15 TIPO ID = 3, ||NOMBRE = Lothórien COSTO = 35.0 TIEMPO = 1.0 CUPO = 30 TIPO ID = 2, ||NOMBRE = Erebor COSTO = 12.0 TIEMPO = 3.0 CUPO = 32 TIPO ID = 3, ||NOMBRE = Bosque Negro COSTO = 5.0 TIEMPO = 4.0 CUPO = 5 TIPO ID = 1]";
		
		assertEquals(atracciones, atrcc.findAll().toString());
	}
	
	// agregado delete en AtraccionDAOImpl
	@Test
	public void deleteAtraccionesTest() throws SQLException {
		Atraccion j = new Atraccion("Bosque Negro", 3.00, 4.00, 12, 1); 
		atrcc.delete(j);
		
		Connection conn = ConnectionProvider.getConnection();
		String sql = "SELECT COUNT(id) AS TOTAL FROM ATRACCION";
		PreparedStatement statement = conn.prepareStatement(sql);
		ResultSet resultados = statement.executeQuery();
		resultados.next();
		int total = resultados.getInt("TOTAL");
		
		String atracciones = "[||NOMBRE = Moria COSTO = 10.0 TIEMPO = 2.0 CUPO = 6 TIPO ID = 1, ||NOMBRE = Minas Tirith COSTO = 5.0 TIEMPO = 2.5 CUPO = 25 TIPO ID = 3, ||NOMBRE = La Comarca COSTO = 3.0 TIEMPO = 6.5 CUPO = 150 TIPO ID = 2, ||NOMBRE = Mordor COSTO = 25.0 TIEMPO = 3.0 CUPO = 4 TIPO ID = 1, ||NOMBRE = Abismo de Helm COSTO = 5.0 TIEMPO = 2.0 CUPO = 15 TIPO ID = 3, ||NOMBRE = Lothórien COSTO = 35.0 TIEMPO = 1.0 CUPO = 30 TIPO ID = 2, ||NOMBRE = Erebor COSTO = 12.0 TIEMPO = 3.0 CUPO = 32 TIPO ID = 3]";
		
		assertEquals(7, total);
		assertEquals(atracciones, atrcc.findAll().toString());
	}
	
	//Agregado el método a AtraccionDAOImpl
	@Test
	public void buscarAtraccionPorNombreTest() {
		
	}

	@After
	public void tearDown() throws Exception {
		String sql = "DELETE FROM ATRACCION";
		Connection conn = ConnectionProvider.getConnection();
		
		PreparedStatement statement = conn.prepareStatement(sql);
		int rows = statement.executeUpdate();
	}
}
