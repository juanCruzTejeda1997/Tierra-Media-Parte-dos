package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import jdbc.ConnectionProvider;
import model.Usuario;
import model.tipo;

public class UserDAOImpl implements UserDAO {

	public int insert(Usuario usuario) {
		try {
			String sql = "INSERT INTO Usuario (nombre, presupuesto, tiempo_disponible, tipo_preferencia_id) VALUES (?, ?, ?, ?)";
			Connection conn = ConnectionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, usuario.getNombre());
			statement.setDouble(2, usuario.getPresupuesto());
			statement.setDouble(3, usuario.getTiempoDisponible());
			statement.setInt(4, usuario.getTipo_preferencia_id());

			int rows = statement.executeUpdate();

			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}
	
	
	public int delete(Usuario usuario) {
		try {
			String sql = "DELETE FROM Usuario WHERE nombre = ?";
			Connection conn = ConnectionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, usuario.getNombre());
			int rows = statement.executeUpdate();

			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}
	

	public int update(Usuario usuario) {

		try {
			String sql = "UPDATE usuario SET presupuesto = ?, TIEMPO = ? WHERE NOMBRE = ?";
			Connection conn = ConnectionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setDouble(1, usuario.getPresupuesto());
			statement.setDouble(2, usuario.getTiempoDisponible());
			statement.setString(3, usuario.getNombre());
			int rows = statement.executeUpdate();

			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}
	
	

	public java.util.List<Usuario> findAll() {
		try {
			String sql = "SELECT * FROM Usuario";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet resultados = statement.executeQuery();

			LinkedList<Usuario> usuarios = new LinkedList<Usuario>();
			while (resultados.next()) {
				usuarios.add(toUsuario(resultados));
			}

			return usuarios;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}
	
	

	public LinkedList<Usuario> getUsuaries() {

		try {
			String sql = "SELECT * FROM Usuario";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet resultados = statement.executeQuery();
			LinkedList<Usuario> usuarios = new LinkedList<Usuario>();

			while (resultados.next()) {
				int id = resultados.getInt(1);
				String nombreDeUsuario = resultados.getString(2);
				Integer tipo_preferencia_id = resultados.getInt(5);
				tipo tipo_preferencia = null;
				double presupuesto = resultados.getDouble(3);
				double tiempo_disponible = resultados.getDouble(4);

				if (tipo_preferencia_id.equals(1)) {
					tipo_preferencia = tipo.AVENTURA;
				} else if (tipo_preferencia_id.equals(2)) {
					tipo_preferencia = tipo.DEGUSTACION;
				} else if (tipo_preferencia_id.equals(3)) {
					tipo_preferencia = tipo.PAISAJE;
				}

				Usuario UsuarioNuevo = new Usuario(id, nombreDeUsuario, presupuesto, tiempo_disponible,
						tipo_preferencia);
				usuarios.add(UsuarioNuevo);

			}

			return usuarios;

		} catch (Exception e) {
			throw new MissingDataException(e);
		}

	}
	
	public Usuario findByUsername(String usuario) {
		try {
			String sql = "SELECT * FROM Usuario WHERE nombre = ?";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, usuario);
			ResultSet resultados = statement.executeQuery();

			Usuario usuarioN = null;

			if (resultados.next()) {
				usuarioN = toUsuario(resultados);
			}

			return usuarioN;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}
	

	private Usuario toUsuario(ResultSet resultados) throws SQLException {
		return new Usuario(resultados.getInt(1), resultados.getString(2), resultados.getDouble(3),
				resultados.getDouble(4), resultados.getInt(5));
		// id,nombre,presupuesto,tiempo y preferencia
	}



	public int countAll() {
		// TODO Auto-generated method stub
		return 0;
	}

	

}
