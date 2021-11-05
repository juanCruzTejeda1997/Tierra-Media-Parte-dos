package DAO;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.LinkedList;


import jdbc.ConnectionProvider;

import model.PromocionPorcentual;

import model.tipo;
import model.Atraccion;

public class PromocionPorcentualDAOImpl implements PromocionPorcentualDAO {
	public int insert(PromocionPorcentual promocion) {
		try {
			String sql = "INSERT INTO Promocion_Porcentual (nombre, atraccion1_id, atraccion2_id, tiempo, descuento, costo, tipo_id, cupo) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

			Connection conn = ConnectionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, promocion.getNombre());
			statement.setInt(2, promocion.getAtraccion1_id());
			statement.setInt(3, promocion.getAtraccion2_id());
			statement.setDouble(4, promocion.getTiempo());
			statement.setDouble(5, promocion.getDescuento());
			statement.setDouble(6, promocion.getCosto());
			statement.setInt(7, promocion.getTipo_id());
			statement.setInt(8, promocion.dbgetCupo());
			int rows = statement.executeUpdate();

			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}
	
	public int buscarIdPromoPorcentual(PromocionPorcentual promocion) {
		try {
			String sql= "SELECT id FROM Promocion_Porcentual WHERE nombre = ?";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			
			statement.setString(1, promocion.getNombre());
			
			ResultSet resultados = statement.executeQuery();
			
			int idPromoPorcentual = resultados.getInt(1);
			
			return idPromoPorcentual;
		}catch(Exception e) {
				throw new MissingDataException(e);
		}
			
	}
	
	public LinkedList<PromocionPorcentual> findAll() {
			try {
				String sql = "SELECT * FROM Promocion_Porcentual ";
				Connection conn = ConnectionProvider.getConnection();
				PreparedStatement statement = conn.prepareStatement(sql);
				ResultSet resultados = statement.executeQuery();

				LinkedList<PromocionPorcentual> promociones = new LinkedList<PromocionPorcentual>();
				while (resultados.next()) {
					promociones.add(toPromocion(resultados));
				}

				return promociones;
			} catch (Exception e) {
				throw new MissingDataException(e);
			}
	}

	public LinkedList<PromocionPorcentual> getPromocionesPorcentuales(LinkedList <Atraccion> atracciones) {
		try {
			String sql = "SELECT * FROM Promocion_Porcentual";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet resultados = statement.executeQuery();
			LinkedList<PromocionPorcentual> promoP = new LinkedList<PromocionPorcentual>();
			

			while (resultados.next()) {
				Integer id = resultados.getInt(1);
				String nombre = resultados.getString(2);
				Integer atraccion1_id = resultados.getInt(3);
				Integer atraccion2_id = resultados.getInt(4);
				double tiempo = resultados.getDouble(5);
				double descuento = resultados.getDouble(6);
				double costo = resultados.getDouble(7);
				Integer tipo_id = resultados.getInt(8);
				Integer cupo = resultados.getInt(9);
				Atraccion atraccion1 = null;
				Atraccion atraccion2 = null;
				tipo tipo = null;
				

				if (tipo_id.equals(1)) {
					tipo = model.tipo.AVENTURA;
				} else if (tipo_id.equals(2)) {
					tipo = model.tipo.DEGUSTACION;
				} else if (tipo_id.equals(3)) {
					tipo = model.tipo.PAISAJE;
				}
				
				for (int i = 0; i < atracciones.size(); i++) {
					if (atraccion1_id.equals(atracciones.get(i).getId())) {
						atraccion1 = atracciones.get(i);
					}
					if (atraccion2_id.equals(atracciones.get(i).getId())) {
						atraccion2 = atracciones.get(i);
						tipo = atracciones.get(i).getTipo();
					}
				}

				PromocionPorcentual p = new PromocionPorcentual(id, nombre, atraccion1, atraccion2, tiempo, descuento,
						costo, tipo, cupo);
				
				PromocionPorcentual d = new PromocionPorcentual(id, nombre, atraccion1, atraccion2, p.calcularTiempo(), descuento, p.calcularCosto(),
						tipo, p.getCupo());
				promoP.add(d);
			}

			return promoP;
			
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}
	
	private PromocionPorcentual toPromocion(ResultSet resultados) throws SQLException {
		return new PromocionPorcentual(resultados.getInt(1), resultados.getString(2), resultados.getInt(3),
				resultados.getInt(4), resultados.getDouble(5), resultados.getDouble(6), resultados.getDouble(7),
				resultados.getInt(8), resultados.getInt(9));

		// String nombre, int tipo, int tipo_promocion, double descuento
	}

	public int countAll() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int update(PromocionPorcentual t) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int delete(PromocionPorcentual t) {
		// TODO Auto-generated method stub
		return 0;
	}

	


	public void restarCupoPromocion(int t) {
		// TODO Auto-generated method stub
		
	}
}