package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
			statement.setInt(8, promocion.dbgetCupo());
			int rows = statement.executeUpdate();

			return rows;
			} catch (Exception e) {
				throw new MissingDataException(e);
			}
	}
	
	public int buscarIdPromoAxB(PromocionAxB promocion) {
		try {
			String sql= "SELECT id FROM PromocionAxB WHERE nombre = ?";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			
			statement.setString(1, promocion.getNombre());
			
			ResultSet resultados = statement.executeQuery();
			
			int idPromoAxB = resultados.getInt(1);
			
			return idPromoAxB;
		}catch(Exception e) {
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
	
	
	public LinkedList<PromocionAxB> getPromocionesAxB(LinkedList<Atraccion> atracciones) {
		try {
			String sql = "SELECT * FROM PromocionAxB";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet resultados = statement.executeQuery();
			LinkedList<PromocionAxB> promoP = new LinkedList<PromocionAxB>();
		
	
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
	
				for (int i = 0; i < atracciones.size(); i++) {
					if(atraccion1_id.equals(atracciones.get(i).getId()) ) {
						atraccion1 = atracciones.get(i);					
					}
					if (atraccion2_id.equals(atracciones.get(i).getId())) {
						atraccion2 = atracciones.get(i);
						tipo = atracciones.get(i).getTipo();
					}
					if (atraccion_gratis_id.equals(atracciones.get(i).getId())) {
						atraccion_gratis = atracciones.get(i);
						tipo = atracciones.get(i).getTipo();
					}
				
				}
				
				PromocionAxB p = new PromocionAxB(id, nombre, atraccion1, atraccion2,atraccion_gratis, tiempo,costo, tipo, cupo);
				
				PromocionAxB d = new PromocionAxB(id, nombre, atraccion1, atraccion2,atraccion_gratis, p.calcularTiempo(), p.calcularCosto(),
						tipo, p.getCupo());
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
		// TODO Auto-generated method stub
		return 0;
	}

	public int delete(PromocionAxB t) {
		// TODO Auto-generated method stub
		return 0;
	}



		
}