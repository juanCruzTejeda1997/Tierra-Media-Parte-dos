package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;

import jdbc.ConnectionProvider;
import model.Atraccion;
import model.Usuario;
import model.tipo;

public class AtraccionDAOImpl implements AtraccionDAO {
	
	public int insert(Atraccion atraccion) {
		
		try {
			String sql = "INSERT INTO Atraccion (nombre,costo, tiempo, cupo, id_tipo_atraccion) VALUES (?, ?, ?, ?, ?)";

			Connection conn = ConnectionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, atraccion.getNombre());
			statement.setDouble(2, atraccion.getCosto());
			statement.setDouble(3, atraccion.getTiempo());
			statement.setInt(4, atraccion.getCupo());
			statement.setInt(5, atraccion.getTipoId());
			int rows = statement.executeUpdate();

			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}
	
	public int update(Atraccion atraccion) {
		try {
			String sql = "UPDATE ATRACCION SET CUPO = ? WHERE NOMBRE = ?";
			Connection conn = ConnectionProvider.getConnection();
	
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, atraccion.getCupo());
			statement.setString(2, atraccion.getNombre());
			int rows = statement.executeUpdate();
	
			return rows;
		}catch(Exception e) {
			throw new MissingDataException(e);
	}
	}

	public int buscarIdAtraccion(Atraccion atraccion) {
		try {
			String sql= "SELECT id FROM atraccion WHERE nombre = ?";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			
			statement.setString(1, atraccion.getNombre());
			
			ResultSet resultados = statement.executeQuery();
			
			int idAtraccion = resultados.getInt(1);
			
			return idAtraccion;
		}catch(Exception e) {
				throw new MissingDataException(e);
		}
			
	}
	
	public LinkedList<Atraccion> findAll() {
		
		try {
			String sql = "SELECT * FROM Atraccion";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet resultados = statement.executeQuery();

			LinkedList<Atraccion> atracciones = new LinkedList<Atraccion>();
			while (resultados.next()) {
				atracciones.add(toAtraccion(resultados));
			}

			return atracciones;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}
	
	
	public ArrayList<Atraccion> getAtracciones() {
		
		try {
			String sql = "SELECT * FROM Atraccion";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet resultados = statement.executeQuery();
	
			ArrayList<Atraccion> atracciones = new ArrayList<Atraccion>();
			while (resultados.next()) {
				int id = resultados.getInt(1);
				String nombreDeAtraccion = resultados.getString(2);
				double costoDeAtraccion = resultados.getDouble(3);
				double tiempo = resultados.getDouble(4);
				int cupo = resultados.getInt(5);
				Integer id_tipo_atraccion = resultados.getInt(6);
				tipo tipoDeAtraccion = null;
	
				if (id_tipo_atraccion.equals(1)) {
					tipoDeAtraccion = tipo.AVENTURA;
				} else if (id_tipo_atraccion.equals(2)) {
					tipoDeAtraccion = tipo.DEGUSTACION;
				} else if (id_tipo_atraccion.equals(3)) {
					tipoDeAtraccion = tipo.PAISAJE;
				}
	
				Atraccion a = new Atraccion(id, nombreDeAtraccion, costoDeAtraccion, tiempo, cupo, tipoDeAtraccion);
				atracciones.add(a);
			}

			return atracciones;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}

	}
	
	
	private Atraccion toAtraccion(ResultSet resultados) throws SQLException {
		return new Atraccion(resultados.getInt(1), resultados.getString(2), resultados.getDouble(3), resultados.getDouble(4), resultados.getInt(5), resultados.getInt(6));
		// String nombre, int tipo, double costo, double tiempo, int cupo
	}
	
	public int countAll() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int delete(Atraccion t) {
		// TODO Auto-generated method stub
		return 0;
	}

	public Atraccion buscarAtraccionPorNombre(String nombre) {
		// TODO Auto-generated method stub
		return null;
	}

}

