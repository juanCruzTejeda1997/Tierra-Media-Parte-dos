package DAO;

import static model.tipo.AVENTURA;
import static model.tipo.DEGUSTACION;
import static model.tipo.PAISAJE;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.LinkedList;

import jdbc.ConnectionProvider;
import model.Atraccion;
import model.Itinerario;
import model.Producto;
import model.PromocionAbsoluta;
import model.PromocionAxB;
import model.PromocionPorcentual;
import model.Usuario;
import model.tipo;

public class ItinerarioDAOImpl implements ItinerarioDAO {

	public Itinerario buscarItinerarioPorid(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<Itinerario> getItinerario() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	public int insert(Itinerario itinerario) {

		try {
			String sql = "INSERT INTO \"main\".\"Itinerario\"\r\n"
					+ "(\"id\", \"atraccion_id\", \"promocion_porcentual_id\", \"promocion_axb_id\", \"promocion_absoluta_id\", \"usuario_id\")\r\n"
					+ "VALUES (?, ?, ?, ?, ?, ?);";

			Connection conn = ConnectionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, itinerario.getId());
			statement.setInt(2, itinerario.getAtraccion_id());
			statement.setInt(3, itinerario.getPromocionPorcentual_id());
			statement.setInt(4, itinerario.getPromocionAxB_id());
			statement.setInt(5,  itinerario.getPromocionAbsoluta_id());
			statement.setInt(6,  itinerario.getUsuario_id());
			int rows = statement.executeUpdate();

			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}
	
	

	
	
	public Itinerario getProductosAdquiridos(){
		try {
		String sql = "SELECT * FROM Itinerario;";
		Connection conn = ConnectionProvider.getConnection();
		PreparedStatement statement = conn.prepareStatement(sql);
		ResultSet resultados = statement.executeQuery();
		//guardo mis productos en la linkedList
		LinkedList<Producto> productosAdquiridos= new LinkedList<Producto>();
		//pero  primero debo conseguir convertirlas en objeto
		AtraccionDAOImpl atrcc = new AtraccionDAOImpl();
		ArrayList<Atraccion> ListaDeAtracciones = atrcc.getAtracciones();
        
		PromocionPorcentualDAOImpl prporcentual = new PromocionPorcentualDAOImpl();
		LinkedList<PromocionPorcentual> ListaDePP = prporcentual.getPromocionesPorcentuales();
		
		PromocionAxBDAOImpl praxb = new PromocionAxBDAOImpl();
		LinkedList<PromocionAxB> ListaDePaxb = praxb.getPromocionesAxB();
		
		PromocionAbsolutaDAOImpl pabs = new PromocionAbsolutaDAOImpl();
		
		LinkedList<PromocionAbsoluta> ListaDePabs = pabs.getPromocionesAbsolutas();
		
		
		UserDAOImpl userDAO = new UserDAOImpl();
		
		LinkedList<Usuario> listaDeUsuarios= userDAO.getUsuaries();
		
		Usuario u = null;
		while (resultados.next()) {
			
			Integer id = resultados.getInt(1);
			Integer atraccion_id =  resultados.getInt(2);
			Integer promocionPorcentual_id =  resultados.getInt(3);
			Integer promocionAxB_id =  resultados.getInt(4);
			Integer promocionAbsoluta_id =  resultados.getInt(5);
			Integer usuario_id = resultados.getInt(6);
		    
		
			for (int i = 0; i < ListaDeAtracciones.size(); i++) {
				if(atraccion_id.equals(ListaDeAtracciones.get(i).getId()) ) {
					Atraccion atraccionDelItinerario = ListaDeAtracciones.get(i);					
				 
					productosAdquiridos.add(atraccionDelItinerario);
				}
				
			}
			
			for (int i = 0; i<ListaDePP.size(); i++) {
				if (promocionPorcentual_id.equals(ListaDePP.get(i).getId())) {
					PromocionPorcentual prpDeItinerario = ListaDePP.get(i);
					
	                   productosAdquiridos.add(prpDeItinerario);
				  }
				}
				
				for (int i = 0; i<ListaDePaxb.size();i++) {
			
				if (promocionAxB_id.equals(ListaDePaxb.get(i).getId())) {
					PromocionAxB prAxBDeItinerario = ListaDePaxb.get(i);
					
					productosAdquiridos.add(prAxBDeItinerario);
				}
				
				}
				
				for (int i= 0; i<ListaDePabs.size(); i++) {
				if (promocionAbsoluta_id.equals(ListaDePabs.get(i).getId())) {
					PromocionAbsoluta pabsDeItinerario = ListaDePabs.get(i);
		             
					productosAdquiridos.add(pabsDeItinerario);
				}
				}
				
				
				for (int i = 0;  i< listaDeUsuarios.size(); i++ ) {
					
					if (usuario_id.equals(listaDeUsuarios.get(i).getId())) {
						u = listaDeUsuarios.get(i);
						
					}
					
				}
					
				
		}
		Itinerario itinerario = new Itinerario(productosAdquiridos, u);
			
			
		
		return itinerario;
			
		
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}
}


