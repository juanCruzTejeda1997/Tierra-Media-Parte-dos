package app;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

import dao.AtraccionDAO;
import dao.AtraccionDAOImpl;
import dao.DAOFactory;
import dao.ItinerarioDAOImpl;
import dao.PromocionAbsolutaDAO;
import dao.PromocionAbsolutaDAOImpl;
import dao.PromocionAxBDAO;
import dao.PromocionAxBDAOImpl;
import dao.PromocionPorcentualDAOImpl;
import dao.UserDAO;
import dao.UserDAOImpl;
import model.Atraccion;
import model.Promocion;
import model.PromocionAbsoluta;
import model.PromocionAxB;
import model.PromocionPorcentual;
import model.Usuario;
import model.tipo;

public class App {
	
	public static void main(String[] args) throws SQLException {
		Scanner sc = new Scanner(System.in);

		AtraccionDAO atrcc = DAOFactory.getAtraccionDAO();
		ArrayList<Atraccion> atracciones = atrcc.getAtracciones();
		Atraccion atrIti = null;
		for (Atraccion atraccion : atracciones) {
			if(atraccion.getNombre().equalsIgnoreCase("Minas Tirith")){
				atrIti = atraccion;
			}
			
		}
		
		PromocionAxBDAO AxB = DAOFactory.getPromocionesAxBs();
		LinkedList<PromocionAxB> promosaxb = AxB.getPromocionesAxB();
		PromocionAxB axbIti = null;
		for (PromocionAxB promocionAxB : promosaxb) {
			if(promocionAxB.getNombre().equalsIgnoreCase("pack Paisaje")) {
				axbIti = promocionAxB;
			}
		}
		
		PromocionAbsolutaDAO absoluta = DAOFactory.getPromocionesAbsolutas();
		LinkedList<PromocionAbsoluta> promosAbs = absoluta.getPromocionesAbsolutas();
		PromocionAbsoluta absIti = null;
		for (PromocionAbsoluta promocionAbsoluta : promosAbs) {
			if(promocionAbsoluta.getNombre().equalsIgnoreCase("pack Degustacion")) {
				absIti = promocionAbsoluta;
			}
		}
		
		UserDAO user = DAOFactory.getUserDAO();
		LinkedList<Usuario> usuarios = user.getUsuaries();
		Usuario usuIti1 = null;
		Usuario usuIti2 = null;
		for (Usuario usuario : usuarios) {
			if(usuario.getNombre().equalsIgnoreCase("Gandalf")) {
				usuIti1 = usuario;
			}
			if(usuario.getNombre().equalsIgnoreCase("Sam")) {
				usuIti2 = usuario;
			}
		}

		ItinerarioDAOImpl it = new ItinerarioDAOImpl();

		it.insertAtraccion(atrIti, usuIti1);
		it.insertPromocionAxB(axbIti, usuIti1);
		it.insertPromocionAbsoluta(absIti, usuIti2);

		it.mostrarItinerario("Gandalf");
		it.mostrarItinerario("Sam");
		
	}
}
