package DAOTests;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.After;
import org.junit.Test;

import DAO.DAOFactory;
import DAO.UserDAO;
import jdbc.ConnectionProvider;
import model.Usuario;

public class InsertarUsuariosDAOTest {

	@Test
	public void test() throws SQLException {
		UserDAO usuario = DAOFactory.getUserDAO();
		
		// múltiples usuarios
		usuario.insert(new Usuario("Eowyn", 10.00, 8.00, 1)); usuario.insert(new Usuario("Gandalf", 100.00, 5.00, 3)); usuario.insert(new Usuario("Sam",36.00, 8.00, 2)); usuario.insert(new Usuario("Galadriel", 120.00, 5.00, 3));
		
		// usuario individual
		Usuario p = new Usuario("Juan", 120.00, 5.00, 3); 
		usuario.insert(p);
		
		Connection conn = ConnectionProvider.getConnection();
		String sql = "SELECT COUNT(id) AS TOTAL FROM USUARIO";
		PreparedStatement statement = conn.prepareStatement(sql);
		ResultSet resultados = statement.executeQuery();
		resultados.next();
		int total = resultados.getInt("TOTAL");
		
		assertEquals(5, total);
	}
	
	@After
	public void tearDown() throws SQLException {
		String sql = "DELETE FROM USUARIO";
		Connection conn = ConnectionProvider.getConnection();

		PreparedStatement statement = conn.prepareStatement(sql);
		int rows = statement.executeUpdate();
	}

}
