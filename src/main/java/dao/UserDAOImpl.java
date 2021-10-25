package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.LinkedList;
import java.util.List;

import jdbc.ConnectionProvider;
import model.Usuario;

public class UserDAOImpl implements UserDAO{


	public int insert(Usuario usuario) {
		try {
		String sql="INSERT INTO usuario (nombre,presupuesto, tiempo_disponible, tipo_id) VALUES (?, ?, ?, ?)";
		Connection conn = ConnectionProvider.getConnection();
		
		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setString(2, usuario.getNombre());
		statement.setDouble(3, usuario.getPresupuesto());
		statement.setInt(5, usuario.getPreferencia());
		statement.setDouble(4, usuario.getTiempoDisponible());
				
		int rows = statement.executeUpdate();
		
		return rows;
		}catch(Exception e) {
			throw new MissingDataException(e);
		}
		
	}
	
	
	public int update(Usuario usuario) {
		try{
			String sql= "UPDATE usuario SET (nombre,presupuesto, tiempo_disponible, tipo_id) VALUES (?, ?, ?, ?)";
		
		Connection conn = ConnectionProvider.getConnection();
		PreparedStatement statement = conn.prepareStatement(sql);
		
		statement.setString(2, usuario.getNombre());
		statement.setDouble(3, usuario.getPresupuesto());
		statement.setInt(5, usuario.getPreferencia());
		statement.setDouble(4, usuario.getTiempoDisponible());
				
		
		int rows = statement.executeUpdate();
		
		return rows;
		}catch(Exception e) {
			throw new MissingDataException(e);
		}
	}
	
	public int delete(Usuario usuario) {
		try{
			String sql= "DELETE FROM usuario WHERE nombre = ?";
		
		Connection conn = ConnectionProvider.getConnection();
		PreparedStatement statement = conn.prepareStatement(sql);
		
		statement.setString(2, usuario.getNombre());
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
			
			statement.setString(2, nombre);
			
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
		
		public Usuario toUser(ResultSet resultados)   {
			try {
			return new Usuario(resultados.getString(2), resultados.getInt(5),  resultados.getDouble(3),  resultados.getDouble(4) );
			}catch(Exception e) {
				throw new MissingDataException(e);
			}
			
		}
		
		public List<Usuario> findAll() {
			try {
			String sql="SELECT * FROM users";
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
		
		public int countAll()  {
		try {
			String sql = "SELECT COUNT(1) AS TOTAL FROM users";
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
