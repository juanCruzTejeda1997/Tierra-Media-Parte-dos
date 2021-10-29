package DAO;

import static model.tipo.AVENTURA;
import static model.tipo.DEGUSTACION;
import static model.tipo.PAISAJE;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;

import jdbc.ConnectionProvider;
import model.Atraccion;
import model.PromocionAbsoluta;
import model.tipo;


public class PromocionAbsolutaDAOImpl implements PromocionAbsolutaDAO{
public int insert(PromocionAbsoluta promocion) {
		try {		
		String sql = "INSERT INTO Promocion_Absoluta (nombre, atraccion1_id, atraccion2_id, tiempo, costo, tipo_id) VALUES (?, ?, ?, ?, ?, ?)";
		
		Connection conn = ConnectionProvider.getConnection();
		
		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setString(1, promocion.getNombre());
		statement.setInt(2, promocion.getAtraccion1_id());
		statement.setInt(3, promocion.getAtraccion2_id());
		statement.setDouble(4, promocion.getTiempo());
		statement.setDouble(5, promocion.getCosto());
		statement.setInt(6, promocion.getTipo_id());
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
				resultados.getInt(4), resultados.getDouble(5), resultados.getDouble(6), resultados.getInt(7));
		
	}
	
	public LinkedList<PromocionAbsoluta> getPromocionesAbsolutas(){
		try {
		String sql = "SELECT * FROM Promocion_Absoluta";
		Connection conn = ConnectionProvider.getConnection();
		PreparedStatement statement = conn.prepareStatement(sql);
		ResultSet resultados = statement.executeQuery();
		LinkedList<PromocionAbsoluta> promoP = new LinkedList<PromocionAbsoluta>();
		AtraccionDAOImpl atraccion = new AtraccionDAOImpl();
		ArrayList<Atraccion> ListaDeAtracciones = atraccion.getAtracciones();

		while (resultados.next()) {
			Integer id = resultados.getInt(1);
			String nombre = resultados.getString(2);
			Integer atraccion1_id = resultados.getInt(3);
			Integer atraccion2_id = resultados.getInt(4);
			double tiempo = resultados.getDouble(5);
			double costo = resultados.getDouble(6);
		    Integer tipo_id = resultados.getInt(7);
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
			
		
			for (int i = 0; i < ListaDeAtracciones.size(); i++) {
				if(atraccion1_id.equals(ListaDeAtracciones.get(i).getId()) ) {
					atraccion1 = ListaDeAtracciones.get(i);					
					
				}
				if (atraccion2_id.equals(ListaDeAtracciones.get(i).getId())) {
					atraccion2 = ListaDeAtracciones.get(i);
					
					tipo = ListaDeAtracciones.get(i).getTipo();
			}
			
				
						
		}
			
			PromocionAbsoluta p = new PromocionAbsoluta(id, nombre, atraccion1, atraccion2, tiempo, costo, tipo);
			promoP.add(p);
	}
		
		return promoP;
		} catch (Exception e) {
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
