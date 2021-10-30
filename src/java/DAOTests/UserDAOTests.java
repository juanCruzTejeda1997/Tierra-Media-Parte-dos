package DAOTests;

import static org.junit.Assert.assertEquals;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import DAO.DAOFactory;
import DAO.UserDAO;
import jdbc.ConnectionProvider;
import model.Usuario;

public class UserDAOTests {
	UserDAO usuario = DAOFactory.getUserDAO();
	Usuario p;
	
	@Before
	public void insert() throws SQLException {
		// múltiples usuarios
		usuario.insert(new Usuario("Eowyn", 10.00, 8.00, 1)); usuario.insert(new Usuario("Gandalf", 100.00, 5.00, 3)); usuario.insert(new Usuario("Sam",36.00, 8.00, 2)); usuario.insert(new Usuario("Galadriel", 120.00, 5.00, 3));
		
		// usuario individual
		p = new Usuario("Juan", 120.00, 5.00, 3); 
		usuario.insert(p);
		
		Connection conn = ConnectionProvider.getConnection();
		String sql = "SELECT COUNT(id) AS TOTAL FROM USUARIO";
		PreparedStatement statement = conn.prepareStatement(sql);
		ResultSet resultados = statement.executeQuery();
		resultados.next();
		int total = resultados.getInt("TOTAL");
		
		assertEquals(5, total);
	}
	
	// Cambiar en UserDAOImpl tiempo por tiempo_disponible
	@Test
	public void actualizarUsuario() throws SQLException { 
		Usuario j = new Usuario("Juan", 200.00, 10.00, 3); 
		usuario.update(j);
		
		String usuarios = "[ | NOMBRE = Eowyn ID PREFERENCIA =1 PRESUPUESTO = 10.0 TIEMPO DISPONIBLE = 8.0,  | NOMBRE = Gandalf ID PREFERENCIA =3 PRESUPUESTO = 100.0 TIEMPO DISPONIBLE = 5.0,  | NOMBRE = Sam ID PREFERENCIA =2 PRESUPUESTO = 36.0 TIEMPO DISPONIBLE = 8.0,  | NOMBRE = Galadriel ID PREFERENCIA =3 PRESUPUESTO = 120.0 TIEMPO DISPONIBLE = 5.0,  | NOMBRE = Juan ID PREFERENCIA =3 PRESUPUESTO = 200.0 TIEMPO DISPONIBLE = 10.0]";
		
		assertEquals(usuarios, usuario.findAll().toString());
		
	}
	
	@Test
	public void buscarUsuarios() throws SQLException {
		// Para que corra bien hay que modificar el toString() de Usuario borrando el campo ID para que no retorne resultados con valores cambiantes
		
		String usuarios = "[ | NOMBRE = Eowyn ID PREFERENCIA =1 PRESUPUESTO = 10.0 TIEMPO DISPONIBLE = 8.0,  | NOMBRE = Gandalf ID PREFERENCIA =3 PRESUPUESTO = 100.0 TIEMPO DISPONIBLE = 5.0,  | NOMBRE = Sam ID PREFERENCIA =2 PRESUPUESTO = 36.0 TIEMPO DISPONIBLE = 8.0,  | NOMBRE = Galadriel ID PREFERENCIA =3 PRESUPUESTO = 120.0 TIEMPO DISPONIBLE = 5.0,  | NOMBRE = Juan ID PREFERENCIA =3 PRESUPUESTO = 120.0 TIEMPO DISPONIBLE = 5.0]";
		
		assertEquals(usuarios, usuario.findAll().toString());
	}
	
	@Test
	public void contarUsuarios() throws SQLException { 
		
	}

	@Test
	public void borrarUsuario() throws SQLException {
		usuario.delete(p);
		
		Connection conn = ConnectionProvider.getConnection();
		String sql = "SELECT COUNT(id) AS TOTAL FROM USUARIO";
		PreparedStatement statement = conn.prepareStatement(sql);
		ResultSet resultados = statement.executeQuery();
		resultados.next();
		int total = resultados.getInt("TOTAL");
		
		String usuarios = "[ | NOMBRE = Eowyn ID PREFERENCIA =1 PRESUPUESTO = 10.0 TIEMPO DISPONIBLE = 8.0,  | NOMBRE = Gandalf ID PREFERENCIA =3 PRESUPUESTO = 100.0 TIEMPO DISPONIBLE = 5.0,  | NOMBRE = Sam ID PREFERENCIA =2 PRESUPUESTO = 36.0 TIEMPO DISPONIBLE = 8.0,  | NOMBRE = Galadriel ID PREFERENCIA =3 PRESUPUESTO = 120.0 TIEMPO DISPONIBLE = 5.0]";
		
		assertEquals(4, total);
		assertEquals(usuarios, usuario.findAll().toString());
	}

	@After
	public void tearDown() throws SQLException {
		String sql = "DELETE FROM USUARIO";
		Connection conn = ConnectionProvider.getConnection();

		PreparedStatement statement = conn.prepareStatement(sql);
		int rows = statement.executeUpdate();
	}
}