package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import jdbc.ConnectionProvider;
import model.Usuario;

public class UsuarioDAO {
	
	public int insert(Usuario usuario) throws SQLException {
		String sql = "INSERT INTO USUARIO (NOMBRE, MONEDAS, TIEMPO, TIPO_ID) VALUES (?, ?, ?, ?)";
		Connection conn = ConnectionProvider.getConnection();

		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setString(1, usuario.getNombre());
		statement.setDouble(2, usuario.getPresupuesto());
		statement.setDouble(3, usuario.getTiempoDisponible());
		statement.setInt(4, usuario.getPreferencia());
		int rows = statement.executeUpdate();

		return rows;
	}
	
	public int update(Usuario usuario) throws SQLException {
		String sql = "UPDATE USUARIO SET MONEDAS = ?, TIEMPO = ? WHERE NOMBRE = ?";
		Connection conn = ConnectionProvider.getConnection();

		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setDouble(1, usuario.getPresupuesto());
		statement.setDouble(2, usuario.getTiempoDisponible());
		statement.setString(3, usuario.getNombre());
		int rows = statement.executeUpdate();

		return rows;
	}

	public List<Usuario> findAll() throws SQLException {
		String sql = "SELECT * FROM USUARIO";
		Connection conn = ConnectionProvider.getConnection();
		PreparedStatement statement = conn.prepareStatement(sql);
		ResultSet resultados = statement.executeQuery();

		List<Usuario> libros = new LinkedList<Usuario>();
		while (resultados.next()) {
			libros.add(toUsuario(resultados));
		}

		return libros;
	}

	private Usuario toUsuario(ResultSet resultados) throws SQLException {
		return new Usuario(resultados.getString(2), resultados.getDouble(3), resultados.getDouble(4), resultados.getInt(5));
		// nombre, monedas, tiempo, preferencia
	}
}
