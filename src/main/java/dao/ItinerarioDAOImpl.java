package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import jdbc.ConnectionProvider;
import model.Atraccion;
import model.Itinerario;
import model.PromocionAbsoluta;
import model.PromocionAxB;
import model.PromocionPorcentual;
import model.Usuario;
import model.tipo;



public class ItinerarioDAOImpl {
	
	UserDAOImpl userImpl = new UserDAOImpl();
	AtraccionDAOImpl atrImpl = new AtraccionDAOImpl();
	PromocionAbsolutaDAOImpl absImpl = new PromocionAbsolutaDAOImpl();
	PromocionAxBDAOImpl axbImpl = new  PromocionAxBDAOImpl();
	PromocionPorcentualDAOImpl porcImpl = new PromocionPorcentualDAOImpl();
	
	
	
	public int insertAtraccion(Atraccion atraccion, Usuario usuario) throws SQLException {
		String sql = "INSERT INTO ITINERARIO (atraccion_id, usuario_id) VALUES (?, ?)";
		Connection conn = ConnectionProvider.getConnection();

		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setInt(1, atrImpl.buscarIdAtraccion(atraccion));
		statement.setInt(2, userImpl.buscarIdUsuario(usuario));
		int rows = statement.executeUpdate();

		return rows;
	}
	
	public int insertPromocionPorcentual(PromocionPorcentual promocion, Usuario usuario) throws SQLException {
		String sql = "INSERT INTO ITINERARIO (promocion_porcentual_id, usuario_id) VALUES (?, ?)";
		Connection conn = ConnectionProvider.getConnection();

		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setInt(1, porcImpl.buscarIdPromoPorcentual(promocion));
		statement.setInt(2, userImpl.buscarIdUsuario(usuario));
		int rows = statement.executeUpdate();

		return rows;
	}
	
	public int insertPromocionAxB(PromocionAxB promocion, Usuario usuario) throws SQLException {
		String sql = "INSERT INTO ITINERARIO (promocion_axb_id, usuario_id) VALUES (?, ?)";
		Connection conn = ConnectionProvider.getConnection();

		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setInt(1, axbImpl.buscarIdPromoAxB(promocion));
		statement.setInt(2, userImpl.buscarIdUsuario(usuario));
		int rows = statement.executeUpdate();

		return rows;
	}

	public int insertPromocionAbsoluta(PromocionAbsoluta promocion, Usuario usuario) throws SQLException {
		String sql = "INSERT INTO ITINERARIO (promocion_absoluta_id, usuario_id) VALUES (?, ?)";
		Connection conn = ConnectionProvider.getConnection();

		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setInt(1, absImpl.buscarIdPromoAbsoluta(promocion));
		statement.setInt(2, userImpl.buscarIdUsuario(usuario));
		int rows = statement.executeUpdate();

		return rows;
	}
	

	public LinkedList<Itinerario> buscarItinerarioPorUsuario(String nombre) {
		try {
			String sql = "SELECT * FROM ITINERARIO WHERE EXISTS (SELECT usuario.id FROM USUARIO WHERE (itinerario.usuario_id = usuario.id AND usuario.nombre = nombre))";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet resultados = statement.executeQuery();
			LinkedList<Itinerario> itinerario = new LinkedList<Itinerario>();
			LinkedList<Usuario> usuarios = userImpl.getUsuaries();
			ArrayList<Atraccion> atracciones = atrImpl.getAtracciones();
			LinkedList<PromocionAbsoluta> promosAbsolutas = absImpl.getPromocionesAbsolutas();
			LinkedList<PromocionAxB> promosAxB = axbImpl.getPromocionesAxB();
			LinkedList<PromocionPorcentual> promosPorcentuales = porcImpl.getPromocionesPorcentuales();
			
			while (resultados.next()) {
				Integer id = resultados.getInt(1);
				Integer atraccion_id = resultados.getInt(2);
				Integer promocion_porcentual_id = resultados.getInt(3);
				Integer promocion_axb_id = resultados.getInt(4);
				Integer promocion_absoluta_id = resultados.getInt(5);
				Integer usuario_id = resultados.getInt(6);
				Atraccion atraccion = null;
				PromocionPorcentual promocionPorcentual = null;
				PromocionAxB promocionAxB = null;
				PromocionAbsoluta promocionAbsoluta = null;
				Usuario usuario = null;
			
				if(atraccion_id != null) {
					for(int i = 0; i < atracciones.size(); i++) {
						if(atraccion_id.equals(atracciones.get(i).getId())) {
							atraccion = atracciones.get(i);
						}
					}
				}
				
				if(promocion_porcentual_id != null) {
					for(int i = 0; i < promosPorcentuales.size(); i++) {
						if(promocion_porcentual_id.equals(promosPorcentuales.get(i).getId())) {
							promocionPorcentual = promosPorcentuales.get(i);					
						}
					}		
				}	
				
				if(promocion_axb_id != null) {
					for(int i = 0; i < promosAxB.size(); i++) {
						if(promocion_axb_id.equals(promosAxB.get(i).getId())) {
							promocionAxB = promosAxB.get(i);					
						}
					}		
				}	
				
				if(promocion_absoluta_id != null) {
					for(int i = 0; i < promosAbsolutas.size(); i++) {
						if(promocion_absoluta_id.equals(promosAbsolutas.get(i).getId())) {
							promocionAbsoluta = promosAbsolutas.get(i);					
						}
					}		
				}	
				
				for(int i = 0; i < usuarios.size(); i++) {
					if(usuario_id.equals(usuarios.get(i).getId())) {
						usuario = usuarios.get(i);
					}
				}
				
				Itinerario it = new Itinerario(id, atraccion, promocionPorcentual, promocionAxB, promocionAbsoluta, usuario);	
				itinerario.add(it);
			}
			
			return itinerario;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	private Itinerario toItinerario(ResultSet resultados) throws SQLException {
		return new Itinerario(resultados.getInt(1), resultados.getInt(2), resultados.getInt(3), resultados.getInt(4), 
				resultados.getInt(5), resultados.getInt(6));
	}
	
	private double calcularCostoTotal(LinkedList<Itinerario> itinerario) {
		double total = 0;
		for (Itinerario it : itinerario) {
			total += it.calcularCosto();
		}
		return total;
	}
	
	private double calcularTiempoTotal(LinkedList<Itinerario> itinerario) {
		double tiempo = 0;
		for (Itinerario it : itinerario) {
			tiempo += it.calcularTiempo();
		}
		return tiempo;
	}
	
	public void mostrarItinerario(String nombre) {
		LinkedList<Itinerario> it = buscarItinerarioPorUsuario(nombre);
		System.out.println(
				"ITINERARIO: \n"
				+ "Usuario = " + it.get(0).getUsuario() + "\n"
						+ "Productos = " + it + "\n"
						+ "Gasto Total = " + calcularCostoTotal(it) + " monedas \n"
						+ "Tiempo Total = " + calcularTiempoTotal(it) + " horas");
	}
	


}
