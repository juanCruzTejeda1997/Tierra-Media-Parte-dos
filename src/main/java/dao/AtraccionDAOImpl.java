package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;

import jdbc.ConnectionProvider;
import model.Atraccion;
import model.tipo;

public class AtraccionDAOImpl {
	public int insert(Atraccion atraccion) throws SQLException {
		String sql = "INSERT INTO Atraccion (nombre,costo, tiempo, cupo, id_tipo_atraccion) VALUES (?, ?, ?, ?, ?)";
		// String nombre, int tipo, double costo, double tiempo,  int cupo
		Connection conn = ConnectionProvider.getConnection();

		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setString(1, atraccion.getNombre());
		statement.setDouble(2, atraccion.getCosto());
		statement.setDouble(3, atraccion.getTiempo());
		statement.setInt(4, atraccion.getCupo());
		statement.setInt(5, atraccion.getTipo());
		int rows = statement.executeUpdate();

		return rows;
	}
	
	public int update(Atraccion atraccion) throws SQLException {
		String sql = "UPDATE ATRACCION SET Cupo = ? WHERE NOMBRE = ?";
		Connection conn = ConnectionProvider.getConnection();

		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setInt(1, atraccion.getCupo());
		statement.setString(2, atraccion.getNombre());
		int rows = statement.executeUpdate();

		return rows;
	}

	public LinkedList<Atraccion> findAll() throws SQLException {
		String sql = "SELECT * FROM Atraccion";
		Connection conn = ConnectionProvider.getConnection();
		PreparedStatement statement = conn.prepareStatement(sql);
		ResultSet resultados = statement.executeQuery();

		LinkedList<Atraccion> atracciones = new LinkedList<Atraccion>();
		while (resultados.next()) {
			atracciones.add(toAtraccion(resultados));
		}

		return atracciones;
	}

	private Atraccion toAtraccion(ResultSet resultados) throws SQLException {
		return new Atraccion(resultados.getInt(1), resultados.getString(2), resultados.getDouble(3), resultados.getDouble(4), resultados.getInt(5), resultados.getInt(6));
		// String nombre, int tipo, double costo, double tiempo,  int cupo
	}

	
	
	public ArrayList<Atraccion> getAtracciones() throws SQLException{
		
		String sql = "SELECT * FROM Atraccion";
		Connection conn = ConnectionProvider.getConnection();
		PreparedStatement statement = conn.prepareStatement(sql);
		ResultSet resultados = statement.executeQuery();

		ArrayList<Atraccion> atracciones = new ArrayList<Atraccion>();
		while (resultados.next()) {
			 String nombreDeAtraccion =resultados.getString(2);
			    double costoDeAtraccion = resultados.getDouble(3);
			    double tiempo = resultados.getDouble(4);
			    int cupo = resultados.getInt(5);
			    Integer id_tipo_atraccion = resultados.getInt(6);
			    tipo tipoDeAtraccion = null;
				

		    			if (id_tipo_atraccion.equals(1)) {
		    				tipoDeAtraccion = tipo.AVENTURA;
		    			} 
		    			else if (id_tipo_atraccion.equals(2)){
		    				tipoDeAtraccion = tipo.DEGUSTACION;
		    			}
		    			else if (id_tipo_atraccion.equals(3)){
		    				tipoDeAtraccion = tipo.PAISAJE;
		    			} 

		    			Atraccion a = new Atraccion(nombreDeAtraccion,costoDeAtraccion,tiempo,cupo, tipoDeAtraccion);
		    			atracciones.add(a);
		}

		return atracciones;
		
	}
	
}

