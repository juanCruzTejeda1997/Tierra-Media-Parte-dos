package DAO;

import static model.tipo.AVENTURA;
import static model.tipo.DEGUSTACION;
import static model.tipo.PAISAJE;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.LinkedList;

import jdbc.ConnectionProvider;
import model.Atraccion;
import model.PromocionAbsoluta;

import model.tipo;


public class PromocionAbsolutaDAOImpl implements PromocionAbsolutaDAO{
public int insert(PromocionAbsoluta promocion) {
		try {		
		String sql = "INSERT INTO Promocion_Absoluta (nombre, atraccion1_id, atraccion2_id, tiempo, costo, tipo_id, cupo) VALUES (?, ?, ?, ?, ?, ?, ?)";
		
		Connection conn = ConnectionProvider.getConnection();
		
		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setString(1, promocion.getNombre());
		statement.setInt(2, promocion.getAtraccion1_id());
		statement.setInt(3, promocion.getAtraccion2_id());
		statement.setDouble(4, promocion.getTiempo());
		statement.setDouble(5, promocion.getCosto());
		statement.setInt(6, promocion.getTipo_id());
		statement.setInt(7, promocion.dbgetCupo());
		int rows = statement.executeUpdate();

		return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	public LinkedList<PromocionAbsoluta> findAll() {
		try {
		String sql = "SELECT * FROM Promocion_Absoluta ";
		Connection conn = ConnectionProvider.getConnection();
		PreparedStatement statement = conn.prepareStatement(sql);
		ResultSet resultados = statement.executeQuery();

		LinkedList<PromocionAbsoluta> promocionesAbs= new LinkedList<PromocionAbsoluta>();
		while (resultados.next()) {
			promocionesAbs.add(toPromocion(resultados));
		}

		return promocionesAbs;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	private PromocionAbsoluta toPromocion(ResultSet resultados) throws SQLException {
		return new PromocionAbsoluta(resultados.getInt(1), resultados.getString(2), resultados.getInt(3), 
				resultados.getInt(4), resultados.getDouble(5), resultados.getDouble(6), resultados.getInt(7), resultados.getInt(8));
		
	}
	
	
	public int buscarIdPromoAbsoluta(PromocionAbsoluta promocion) {
		try {
			String sql= "SELECT id FROM Promocion_Absoluta WHERE nombre = ?";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			
			statement.setString(1, promocion.getNombre());
			
			ResultSet resultados = statement.executeQuery();
			
			int idPromoAbsoluta = resultados.getInt(1);
			
			return idPromoAbsoluta;
		}catch(Exception e) {
				throw new MissingDataException(e);
		}
			
	}
	
	
	
	public LinkedList<PromocionAbsoluta> getPromocionesAbsolutas(LinkedList<Atraccion> atracciones){
		try {
		String sql = "SELECT * FROM Promocion_Absoluta";
		Connection conn = ConnectionProvider.getConnection();
		PreparedStatement statement = conn.prepareStatement(sql);
		ResultSet resultados = statement.executeQuery();
		LinkedList<PromocionAbsoluta> promoP = new LinkedList<PromocionAbsoluta>();
		

		while (resultados.next()) {
			Integer id = resultados.getInt(1);
			String nombre = resultados.getString(2);
			Integer atraccion1_id = resultados.getInt(3);
			Integer atraccion2_id = resultados.getInt(4);
			double tiempo = resultados.getDouble(5);
			double costo = resultados.getDouble(6);
		    Integer tipo_id = resultados.getInt(7);
		    int cupo = resultados.getInt(7);
			Atraccion atraccion1 = null;
			Atraccion atraccion2 = null;	
			tipo tipo = null;
			
			if (tipo_id.equals(1)) {
				tipo = AVENTURA;
			} else if (tipo_id.equals(2)) {
				tipo = DEGUSTACION;
			} else if (tipo_id.equals(3)) {
				tipo = PAISAJE;
			}
			
		
			for (int i = 0; i < atracciones.size(); i++) {
				if(atraccion1_id.equals(atracciones.get(i).getId()) ) {
					atraccion1 = atracciones.get(i);					
					
				}
				if (atraccion2_id.equals(atracciones.get(i).getId())) {
					atraccion2 = atracciones.get(i);
					
					tipo = atracciones.get(i).getTipo();
			}
			
				
						
		}
			
			
			
			
			PromocionAbsoluta p = new PromocionAbsoluta(id, nombre, atraccion1, atraccion2, tiempo, costo, tipo, cupo);
			
			PromocionAbsoluta d = new PromocionAbsoluta(id, nombre, atraccion1, atraccion2, p.calcularTiempo(), p.getCosto() ,tipo, p.getCupo());
			promoP.add(d);
	}
		
		return promoP;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}
	
	

	public void restarCupoPromocion (int id) {
		
		String sql = "SELECT atraccion1_id, atraccion2_id, atraccion_gratis_id\r\n"
				+ "FROM PromocionAxB\r\n"
				+ "WHERE id = ?"; 
				
				

	Connection conn;
		try {
			conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, id);
			ResultSet resultados = statement.executeQuery();
			
			while (resultados.next()) {
			int idAtraccion1 = resultados.getInt(1);
			int idAtraccion2 = resultados.getInt(2);
		    int idAtraccion3 = resultados.getInt(3);
			AtraccionDAO atrcc = DAOFactory.getAtraccionDAO();
			atrcc.restarCupo(idAtraccion1);
            atrcc.restarCupo(idAtraccion2);	
			atrcc.restarCupo(idAtraccion3);
			}
		} catch (Exception e){
			throw new MissingDataException(e);
			
		}
}
	public int countAll() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int update(PromocionAbsoluta t) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int delete(PromocionAbsoluta t) {
		// TODO Auto-generated method stub
		return 0;
	}


	

	
}
