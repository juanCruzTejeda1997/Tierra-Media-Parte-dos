package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import jdbc.ConnectionProvider;
import model.Usuario;
import model.tipo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import jdbc.ConnectionProvider;
import model.Usuario;
import model.tipo;

public class UserDAOImpl implements UserDAO{

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
		} catch(Exception e) {
			throw new MissingDataException(e);
		}
	}
	
	public int update(Usuario usuario) {
		try {
			String sql = "UPDATE usuario SET presupuesto = ?, tiempo_disponible = ? WHERE NOMBRE = ?";
			Connection conn = ConnectionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setDouble(1, usuario.getPresupuesto());
			statement.setDouble(2, usuario.getTiempoDisponible());
			int rows = statement.executeUpdate();

			return rows;
		
		} catch(Exception e) {
			throw new MissingDataException(e);
		}
	}


	public int delete(Usuario usuario) {
		try{
			String sql= "DELETE FROM usuario WHERE nombre = ?";
		
		Connection conn = ConnectionProvider.getConnection();
		PreparedStatement statement = conn.prepareStatement(sql);
		
		statement.setString(1, usuario.getNombre());
		int rows = statement.executeUpdate();
		
		return rows;
		
		}catch(Exception e) {
			throw new MissingDataException(e);
		}
	}
		
		
	public Usuario findByUsername(String nombre) {
		try {
			String sql= "SELECT * FROM usuario WHERE nombre = ?";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			
			statement.setString(1, nombre);
			
			ResultSet resultados = statement.executeQuery();
			
			Usuario usuario = null;
			
			if(resultados.next()) {
				usuario = toUser(resultados);
			}
			
			return usuario;
		}catch(Exception e) {
				throw new MissingDataException(e);
		}
			
	}
	
	public int buscarIdUsuario(Usuario usuario) {
		try {
			String sql= "SELECT id FROM usuario WHERE nombre = ?";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			
			statement.setString(1, usuario.getNombre());
			
			ResultSet resultados = statement.executeQuery();
			
			int idUsuario = resultados.getInt(1);
			
			return idUsuario;
		}catch(Exception e) {
				throw new MissingDataException(e);
		}
			
	}
	
	public Usuario toUser(ResultSet resultados) throws SQLException {
		return new Usuario(resultados.getInt(1), resultados.getString(2), resultados.getDouble(3),
				resultados.getDouble(4), resultados.getInt(5));
			
	}
		
	public List<Usuario> findAll() {
		try {
			String sql="SELECT * FROM usuario";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			
			ResultSet resultados= statement.executeQuery();
			
			List<Usuario> usuarios=new LinkedList<Usuario>();
			
			while(resultados.next()) {
				usuarios.add(toUser(resultados));
			}
			
			return usuarios;
		}catch(Exception e) {
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
	
	
	public int countAll()  {
		try {
			String sql = "SELECT COUNT(1) AS TOTAL FROM usuario";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			 
			ResultSet resultados = statement.executeQuery();
			resultados.next();
			
			int total = resultados.getInt("TOTAL");
			
			return total;
		}catch(Exception e) {
			throw new MissingDataException(e);
		}
			
	}

	




	
}