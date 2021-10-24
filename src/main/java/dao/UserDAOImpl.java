package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.LinkedList;
import java.util.List;

import jdbc.ConnectionProvider;
import model.User;

public class UserDAOimpl implements userDAO{


	public int insert(Usuario usuario) {
		try {
		String sql="INSERT INTO usuario (nombre,preferencia, presupuesto, tiempo_disponible, id_itinerario) VALUES (?, ?, ?, ?, ?)";
		Connection conn = ConnectionProvider.getConnection();
		
		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setString(1, usuario.getNombre());
		statement.setString(2, usuario.getPreferencia());
		statement.setString(3, usuario.getPresupuesto());
		statement.setString(4, usuario.getTiempoDisponible());
		statement.setString(5, usuario.getItinerario());
		
		int rows = statement.executeUpdate();
		
		return rows;
		}catch(Exception e) {
			throw new MissingDataException(e);
		}
		
	}
	
	
	public int update(Usuario usuario) {
		try{
			String sql= "UPDATE usuario SET  (nombre,preferencia, presupuesto, tiempo_disponible, id_itinerario) VALUES (?, ?, ?, ?, ?)";
		
		Connection conn = ConnectionProvider.getConnection();
		PreparedStatement statement = conn.prepareStatement(sql);
		
		statement.setString(1, usuario.getNombre());
		statement.setString(2, usuario.getPreferencia());
		statement.setString(3, usuario.getPresupuesto());
		statement.setString(4, usuario.getTiempoDisponible());
		statement.setString(5, usuario.getItinerario());
		
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
		
		public Usuario toUser(ResultSet resultados) {
			try {
			return new Usuario(resultados.getString(1), resultados.getString(2),  resultados.getString(3),  resultados.getString(4) );
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
