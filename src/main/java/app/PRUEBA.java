package app;

import java.sql.SQLException;

import DAO.AtraccionDAO;
import DAO.DAOFactory;

import DAO.PromocionAbsolutaDAO;
import DAO.PromocionAxBDAO;
import DAO.PromocionPorcentualDAO;
import DAO.UserDAO;
import model.Atraccion;
import model.PromocionAbsoluta;
import model.PromocionAxB;
import model.PromocionPorcentual;
import model.Usuario;

public class PRUEBA {

	public static void main(String[] args) throws SQLException {

		// PRUEBAS DE INSERT, FINDALL, CONVERTOS DE OBJETOS FUNCIONANDO

		
		
		  System.out.println("------------------------USUARIOS---------------------");
		  
		  System.out.println("Inserto un usuario------------------------------------");
		  UserDAO usuario = DAOFactory.getUserDAO();
		  
		  usuario.insert(new Usuario("Tomi", 10.00, 8.00, 1));
		  
		  System.out.
		  println("lo encuentro y lo cuento------------------------------------");
		  System.out.println(usuario.findAll());
		  System.out.println(usuario.countAll());
		  
		  
		  System.out.println("lo convierto en objeto---------------------------------"
		  );
		  
		  System.out.println(usuario.getUsuaries());
		  
		  System.out.println("------------------------ATRACCION---------------------");
		  
		  System.out.
		  println("------------------------creo atracciones y las inserto---------------------"
		  ); AtraccionDAO atrcc = DAOFactory.getAtraccionDAO(); atrcc.insert(new
		  Atraccion("Nueva", 10.00, 2.00, 6, 1));
		  
		  System.out.
		  println("------------------------las traigo todas de la base de datos---------------------"
		  ); System.out.println(atrcc.findAll());
		  
		  System.out.
		  println("--------------------ahora las convierto en objeto---------------------"
		  ); System.out.println(atrcc.getAtracciones());
		 
		  
		  
		  
		  System.out.println("------------------------PROMOCIONES---------------------"
		  );
		  
		  System.out.println("------probamos insertar una promocion porcentual-----");
		  PromocionPorcentualDAO nuevaPorcentual =
		  DAOFactory.getPromocionesPorcentuales();
		  
		  nuevaPorcentual.insert(new PromocionPorcentual("pack Nuevo PORC", 8, 3, 0,
		  20.00, 0, 1, 5));
		  
		  System.out.println("ahora traemos todo -----------------------");
		  System.out.println(nuevaPorcentual.findAll());
		  
		  System.out.println("OBJETO---------------------------------");
		  System.out.println(nuevaPorcentual.getPromocionesPorcentuales());
		  
		 

		
		  System.out.
		  println("------probamos insertar una promocion axb-----------------");
		  
		  PromocionAxBDAO nuevaAxB = DAOFactory.getPromocionesAxBs();
		  nuevaAxB.insert(new PromocionAxB("pack JAJ AXB", 2, 5, 7, 0.00, 0.00, 3, 5));
		  
		  
		  
		  System.out.
		  println("ahora traemos la promocion axb------------------------------------------"
		  ); System.out.println(nuevaAxB.findAll());
		  
		  System.out.println("OBJETO------------------------------");
		  System.out.println(nuevaAxB.getPromocionesAxB());
		 

		
		  System.out.
		  println("hago una promo absoluta ------------------------------------------------"
		  );
		  
		  PromocionAbsolutaDAO nuevaAbs = DAOFactory.getPromocionesAbsolutas();
		  
		  nuevaAbs.insert(new PromocionAbsoluta("Pack JIJI ABS", 6, 3, 0.00, 36.00, 2,
		  2));
		  
		  
		  System.out.
		  println("------inserta la promocion Abs, ahora a ver si la trae-----");
		
		  System.out.println(nuevaAbs.findAll());
		  
		  System.out.println("OBJETOs------------------------------");
		  System.out.println(nuevaAbs.getPromocionesAbsolutas());
		  
		  System.out.
		  println("------------------------ESTO FUNCIONA HERMOSAMENTE!--------------------"
		  );
		 

	}
}
