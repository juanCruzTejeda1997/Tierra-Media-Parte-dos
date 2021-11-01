package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;


import jdbc.ConnectionProvider;
import model.Atraccion;

import model.PromocionAxB;

import model.tipo;


public class PromocionAxBDAOImpl implements PromocionAxBDAO {
	public int insert(PromocionAxB promocion) {
		try {
		String sql = "INSERT INTO PromocionAxB (nombre, atraccion1_id, atraccion2_id, atraccion_gratis_id, tiempo, costo, tipo_id, cupo) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		
		Connection conn = ConnectionProvider.getConnection();
		
		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setString(1, promocion.getNombre());
		statement.setInt(2, promocion.getAtraccion1_id());
		statement.setInt(3, promocion.getAtraccion2_id());
		statement.setInt(4, promocion.getAtraccion_gratis_id());
		statement.setDouble(5, promocion.getTiempo());
		statement.setDouble(6, promocion.getCosto());
		statement.setInt(7, promocion.getTipo_id());
		statement.setInt(8, promocion.getCupo());
		int rows = statement.executeUpdate();

		return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	public LinkedList<PromocionAxB> findAll() {
		try {
		String sql = "SELECT * FROM PromocionAxB ";
		Connection conn = ConnectionProvider.getConnection();
		PreparedStatement statement = conn.prepareStatement(sql);
		ResultSet resultados = statement.executeQuery();

		LinkedList<PromocionAxB> promocionesAxB = new LinkedList<PromocionAxB>();
		while (resultados.next()) {
			promocionesAxB.add(toPromocion(resultados));
		}

		return promocionesAxB;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}
	
	public LinkedList<PromocionAxB> getPromocionesAxB() {
		try {
		String sql = "SELECT * FROM PromocionAxB";
		Connection conn = ConnectionProvider.getConnection();
		PreparedStatement statement = conn.prepareStatement(sql);
		ResultSet resultados = statement.executeQuery();
		LinkedList<PromocionAxB> promoP = new LinkedList<PromocionAxB>();
		AtraccionDAOImpl atraccion = new AtraccionDAOImpl();
		ArrayList<Atraccion> ListaDeAtracciones = atraccion.getAtracciones();

		while (resultados.next()) {
			Integer id = resultados.getInt(1);
			String nombre = resultados.getString(2);
			Integer atraccion1_id = resultados.getInt(3);
			Integer atraccion2_id = resultados.getInt(4);
			Integer atraccion_gratis_id = resultados.getInt(5);
			double tiempo = resultados.getDouble(6);
			double costo = resultados.getDouble(7);
			Integer tipo_id = resultados.getInt(8);
			Integer cupo = resultados.getInt(9);
			Atraccion atraccion1 = null;
			Atraccion atraccion2 = null;	
			Atraccion atraccion_gratis = null;
			tipo tipo = null;
			
			
		
			
			if (tipo_id.equals(1)) {
				tipo = model.tipo.AVENTURA;
			} else if (tipo_id.equals(2)) {
				tipo = model.tipo.DEGUSTACION;
			} else if (tipo_id.equals(3)) {
				tipo = model.tipo.PAISAJE;
			}
			

			for (int i = 0; i < ListaDeAtracciones.size(); i++) {
				if(atraccion1_id.equals(ListaDeAtracciones.get(i).getId()) ) {
					atraccion1 = ListaDeAtracciones.get(i);					
				}
				if (atraccion2_id.equals(ListaDeAtracciones.get(i).getId())) {
					atraccion2 = ListaDeAtracciones.get(i);
					tipo = ListaDeAtracciones.get(i).getTipo();
			}
				if (atraccion_gratis_id.equals(ListaDeAtracciones.get(i).getId())) {
					atraccion_gratis = ListaDeAtracciones.get(i);
					tipo = ListaDeAtracciones.get(i).getTipo();
			}
			
		}
			
			PromocionAxB p = new PromocionAxB(id, nombre, atraccion1, atraccion2,atraccion_gratis, tiempo,costo, tipo, cupo);
			
			PromocionAxB d = new PromocionAxB(id, nombre, atraccion1, atraccion2,atraccion_gratis, p.calcularTiempo(), p.calcularCosto(),
					tipo, p.calcularCupo());
			promoP.add(d);
	}
		
		return promoP;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}
	

	private PromocionAxB toPromocion(ResultSet resultados) throws SQLException {
		return new PromocionAxB(resultados.getInt(1), resultados.getString(2), resultados.getInt(3), resultados.getInt(4), 
				resultados.getInt(5), resultados.getDouble(6), resultados.getDouble(7), resultados.getInt(8), resultados.getInt(9));
		
	}

	public int countAll() {
		// TODO Auto-generated method stub
		return 0;
	}

	

	public int update(PromocionAxB t) {
		String sql = "UPDATE promocionAxB SET atraccion_gratis_id = ? WHERE NOMBRE = ?";
		Connection conn;
		try {
			conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, t.getAtraccion_gratis_id());
			statement.setString(2, t.getNombre());
			int rows = statement.executeUpdate();
			
			return rows;
		} catch (SQLException e) {
			throw new MissingDataException(e);
		}
	}

	public int delete(PromocionAxB t) {
		try {
			String sql = "DELETE FROM promocionAxB WHERE nombre = ?";
			Connection conn = ConnectionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, t.getNombre());
			int rows = statement.executeUpdate();

			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}
	
	

	
		
}