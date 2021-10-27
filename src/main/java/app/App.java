package app;

import java.sql.SQLException;

import DAO.AtraccionDAO;
import DAO.AtraccionDAOImpl;
import DAO.PromocionDAOImpl;
import DAO.UserDAO;
import DAO.UserDAOImpl;
import model.Atraccion;
import model.Promocion;
import model.PromocionPorcentual;
import model.Usuario;

public class App {
	
	public static void main(String[] args) throws SQLException {
		
		
		System.out.println("------Ahora no sé cómo hacer la promoción-----");
		PromocionDAOImpl packAventura = new PromocionDAOImpl();
		packAventura.insertPromocionPorcentual(new PromocionPorcentual(1, "Pack tomi", 1, 1, 0.2, 20.0, 1));
		System.out.println(packAventura.findAllPromocionesPorcentuales());
		
	}
}
