package app;
import java.util.ArrayList;
import java.util.LinkedList;

import DAO.AtraccionDAO;
import DAO.AtraccionDAOImpl;
import DAO.DAOFactory;
import DAO.ItinerarioDAOImpl;
import DAO.PromocionAbsolutaDAO;
import DAO.PromocionAbsolutaDAOImpl;
import DAO.PromocionAxBDAOImpl;
import DAO.PromocionDAO;
import DAO.PromocionPorcentualDAO;
import DAO.PromocionPorcentualDAOImpl;
import DAO.UserDAOImpl;
import model.*;

public class App1 {

	private LinkedList<Producto> productosDeTierraMedia = new LinkedList<Producto>();
	private LinkedList<Usuario> usuarios = new LinkedList<Usuario>();
	
	
	public LinkedList<Producto> getProductosDeTierraMedia() {
		return productosDeTierraMedia;
	}

	public LinkedList<Usuario> getUsuarios() {
		return usuarios;
	}
   public void cargaDatos(){
		
		AtraccionDAO atrcc = DAOFactory.getAtraccionDAO();
		PromocionAbsolutaDAOImpl prA = DAOFactory.getPromocionesAbsolutas();
		PromocionAxBDAOImpl prAxB = DAOFactory.getPromocionesAxBs();
		PromocionPorcentualDAOImpl prP =  DAOFactory.getPromocionesPorcentuales();
		UserDAOImpl uDao = DAOFactory.getUserDAO();
		//cargoMisUsuarios
		usuarios = uDao.getUsuaries();
		//tomo de mi base de datos las atracciones
		ArrayList<Atraccion> atraccionesTM = new ArrayList<Atraccion>();
		atraccionesTM = atrcc.getAtracciones();
		
		//tomo de mi base de datos las promociones
		LinkedList<PromocionAbsoluta> promocionesA_TM = new LinkedList <PromocionAbsoluta>();
		promocionesA_TM = prA.getPromocionesAbsolutas();
		
		
		LinkedList<PromocionPorcentual> promocionesP_TM = new LinkedList <PromocionPorcentual>();
		promocionesP_TM  = prP.getPromocionesPorcentuales();
		
		
		LinkedList<PromocionAxB> promocionesAxB_TM = new LinkedList<PromocionAxB>();
		promocionesAxB_TM= prAxB.getPromocionesAxB();
		
		 //agrego mis productos a mi lista de productos
		for (Atraccion atraccion : atraccionesTM) {
			productosDeTierraMedia.add(atraccion);
		}

		for (Promocion promocion : promocionesA_TM) {
			productosDeTierraMedia.add(promocion);
		}
		
		for (Promocion promocion : promocionesAxB_TM) {
			productosDeTierraMedia.add(promocion);
		}
		
		for (Promocion promocion : promocionesP_TM) {
			productosDeTierraMedia.add(promocion);
		}
		
		
		
	 this.productosDeTierraMedia = productosDeTierraMedia;
     this.usuarios = usuarios;	
	}
	
	
	
	
	
public static void main(String[] args) {
	
	ItinerarioDAOImpl itinerariodao = new ItinerarioDAOImpl();
	
	
	
	
	System.out.println(itinerariodao.getProductosAdquiridos());
}





		
	
}
