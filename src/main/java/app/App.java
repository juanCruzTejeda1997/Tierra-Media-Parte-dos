package app;



import java.sql.SQLException;


import DAO.AtraccionDAOImpl;
import DAO.DAOFactory;
import DAO.PromocionAbsolutaDAOImpl;
import DAO.PromocionAxBDAOImpl;
import DAO.PromocionPorcentualDAOImpl;
import DAO.UserDAO;
import DAO.UserDAOImpl;
import model.Atraccion;
import model.PromocionAbsoluta;
import model.PromocionAxB;
import model.PromocionPorcentual;
import model.Usuario;


public class App {
	
	public static void main(String[] args) throws SQLException {
		
		
		
		/*	UserDAO userDAO = DAOFactory.getUserDAO();
		
			
			System.out.println("----------------------------");
			Usuario tomi = new Usuario(2, "tomi", 20.00, 20.00, 1);
			userDAO.insert(tomi);
			
			System.out.println(userDAO.findAll());
			System.out.println(userDAO.countAll());
			
			// Usuarios extrayendo, contando y agregando.
		
		 System.out.println("------probamos insertar una promocion-----");
		 PromocionPorcentualDAOImpl nuevaPorcentual = new PromocionPorcentualDAOImpl();
		 nuevaPorcentual.insertPromocionPorcentual(new PromocionPorcentual( "jasms", 2, 3, 30.0, 0.6, 20.0, 1 ));
		
		 System.out.println("------inserta la promocion, ahora a ver si la trae-----");
		 System.out.println(nuevaPorcentual.findAllPromocionesPorcentuales());
		 // Trae e inserta perfecto!
		 
		
		System.out.println("------probamos insertar una promocion axb-----");
		
		 PromocionAxBDAOImpl nuevaAxB = new PromocionAxBDAOImpl();
		 nuevaAxB.insertPromocionAxB(new PromocionAxB("Paisaje", 1, 2, 1, 20.00, 20.00, 1));
		 nuevaAxB.insertPromocionAxB(new PromocionAxB("Paisaje", 1, 2, 1, 20.00, 20.00, 1));
		 System.out.println("------inserta la promocion AxB, ahora a ver si la trae-----");
		 System.out.println(nuevaAxB.findAllPromocionesAxB());
		 // Trae e inserta perfecto!
		 
		 // hice cambios y trae e inserta bien pero no trae el id correctamente. 
		 
		 System.out.println("------probamos insertar una promocion absoluta-----");
			
		 PromocionAbsolutaDAOImpl nuevaAbs = new PromocionAbsolutaDAOImpl();
		 nuevaAbs.insertPromocionAbsoluta(new PromocionAbsoluta("holaque", 1, 2, 20.00, 20.00, 1));
		 nuevaAbs.insertPromocionAbsoluta(new PromocionAbsoluta("talcomo", 1, 2, 20.00, 20.00, 1));
		 System.out.println("------inserta la promocion Abs, ahora a ver si la trae-----");
		 System.out.println(nuevaAbs.findAllPromocionesAbsolutas());
		 // Trae e inserta pero no me trae bien el id :(
		 
		 System.out.println("------probamos insertar una promocion absoluta-----");
			
		 AtraccionDAOImpl nuevaA = new AtraccionDAOImpl();
		 nuevaA.insert(new Atraccion("Moria", 20.00, 8.00, 8,2));
		 nuevaA.insert(new Atraccion("Minas", 20.00, 8.00, 8,2));
		
		 System.out.println("------inserta la Atracc, ahora a ver si la trae-----");
		 System.out.println(nuevaA.findAll());
		 // Trae e inserta pero no me trae bien el id : */
		
		
		 System.out.println("------a----");
		 
		 UserDAOImpl nuevaA = new UserDAOImpl();
		 System.out.println(nuevaA.getUsuaries());
		
		
	}
}
