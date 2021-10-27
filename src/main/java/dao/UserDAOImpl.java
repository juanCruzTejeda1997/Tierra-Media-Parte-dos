package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import jdbc.ConnectionProvider;
import model.Usuario;

public class UserDAOImpl implements UserDAO{

	public int insert(Usuario usuario) throws SQLException {
		String sql = "INSERT INTO usuario (nombre, presupuesto, tiempo_disponible, tipo_id) VALUES (?, ?, ?, ?)";
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
		String sql = "UPDATE usuario SET presupuesto = ?, TIEMPO = ? WHERE NOMBRE = ?";
		Connection conn = ConnectionProvider.getConnection();

		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setDouble(1, usuario.getPresupuesto());
		statement.setDouble(2, usuario.getTiempoDisponible());
		statement.setString(3, usuario.getNombre());
		int rows = statement.executeUpdate();

		return rows;
	}

	public java.util.List<Usuario> findAll() {
		String sql = "SELECT * FROM USUARIO";
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		PreparedStatement statement = null;
		try {
			statement = conn.prepareStatement(sql);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		ResultSet resultados = null;
		try {
			resultados = statement.executeQuery();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		LinkedList<Usuario> libros = new LinkedList<Usuario>();
		try {
			while (resultados.next()) {
				try {
					libros.add(toUsuario(resultados));
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return libros;
	}

	private Usuario toUsuario(ResultSet resultados) throws SQLException {
		return new Usuario(resultados.getString(2), resultados.getDouble(3), resultados.getDouble(4), resultados.getInt(5));
		// nombre, monedas, tiempo, preferencia
	}

	public Usuario findByUsername(String usuario) {
		// TODO Auto-generated method stub
		return null;
	}

	public int countAll() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int delete(Usuario t) {
		// TODO Auto-generated method stub
		return 0;
	}




	
}
