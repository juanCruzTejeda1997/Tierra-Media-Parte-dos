package app;

import java.sql.SQLException;

import DAO.AtraccionDAOImpl;
import DAO.PromocionAbsolutaDAOImpl;
import DAO.PromocionAxBDAOImpl;
import DAO.PromocionPorcentualDAOImpl;
import DAO.UserDAOImpl;
import model.Atraccion;
import model.PromocionAbsoluta;
import model.PromocionAxB;
import model.PromocionPorcentual;
import model.Usuario;

public class App {

	public static void main(String[] args) throws SQLException {
		System.out.println("------------------------USUARIOS---------------------");
		
		

		System.out.println("Inserto un usuario------------------------------------");
		UserDAOImpl usuario = new UserDAOImpl();
		usuario.insert(new Usuario(2, "tomi", 20.00, 20.00, 1));
		
		System.out.println("lo encuentro y lo cuento------------------------------------");		
		System.out.println(usuario.findAll());
		System.out.println(usuario.countAll());
		
		System.out.println("lo convierto en objeto---------------------------------");
		UserDAOImpl nuevaA = new UserDAOImpl();
		System.out.println(nuevaA.getUsuaries());
		
		
		
		System.out.println("------------------------PROMOCIONES---------------------");

		

		System.out.println("------probamos insertar una promocion porcentual-----");
		PromocionPorcentualDAOImpl nuevaPorcentual = new PromocionPorcentualDAOImpl();
		nuevaPorcentual.insertPromocionPorcentual(new PromocionPorcentual("soy una promo", 2, 3, 30.0, 0.6, 2, 1));

		System.out.println("ahora traemos todo -----------------------");
		System.out.println(nuevaPorcentual.findAllPromocionesPorcentuales());
		
		System.out.println("aun no lo convierto en objeto (work in progress)---------------------------------");
		
		

		System.out.println("------probamos insertar una promocion axb-----------------");

		PromocionAxBDAOImpl nuevaAxB = new PromocionAxBDAOImpl();
		nuevaAxB.insertPromocionAxB(new PromocionAxB("Paisaje", 1, 2, 1, 20.00, 20.00, 1));
		nuevaAxB.insertPromocionAxB(new PromocionAxB("Paisaje", 1, 2, 1, 20.00, 20.00, 1));
		
		System.out.println("ahora traemos la promocion axb------------------------------------------");
		System.out.println(nuevaAxB.findAllPromocionesAxB());

		System.out.println("no convierto en objeto porque work in progres------------------------------");
		
		

		System.out.println("hago una promo absoluta ------------------------------------------------");

		PromocionAbsolutaDAOImpl nuevaAbs = new PromocionAbsolutaDAOImpl();
		nuevaAbs.insertPromocionAbsoluta(new PromocionAbsoluta("holaque", 1, 2, 20.00, 20.00, 1));
		nuevaAbs.insertPromocionAbsoluta(new PromocionAbsoluta("talcomo", 1, 2, 20.00, 20.00, 1));
		
		System.out.println("------inserta la promocion Abs, ahora a ver si la trae-----");
		System.out.println(nuevaAbs.findAllPromocionesAbsolutas());
		
		
		System.out.println("------------------------ATRACCION---------------------");

		
		System.out.println("------------------------creo atracciones y las inserto---------------------");
		AtraccionDAOImpl atrcc = new AtraccionDAOImpl();
		atrcc.insert(new Atraccion("moria", 20.00, 20.00, 8, 2));
		atrcc.insert(new Atraccion("casan", 20.00, 20.00, 8, 2));
		atrcc.insert(new Atraccion("alfano", 20.00, 20.00, 8, 2));
		atrcc.insert(new Atraccion("tomikapo", 20.00, 20.00, 8, 2));
		
		System.out.println("------------------------las traigo todas de la base de datos---------------------");
		System.out.println(atrcc.findAll());
		
		System.out.println("--------------------ahora las convierto en objeto---------------------");
		System.out.println(atrcc.getAtracciones());
		
		System.out.println("------------------------ESTO FUNCIONA HERMOSAMENTE!--------------------");


		
		
		
	}
}
