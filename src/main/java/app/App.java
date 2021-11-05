package app;

import java.sql.SQLException;

import DAO.AtraccionDAO;
import DAO.AtraccionDAOImpl;
import DAO.DAOFactory;
import DAO.ItinerarioDAOImpl;
import DAO.PromocionAbsolutaDAO;
import DAO.PromocionAbsolutaDAOImpl;
import DAO.PromocionAxBDAO;
import DAO.PromocionAxBDAOImpl;
import DAO.PromocionPorcentualDAO;
import DAO.PromocionPorcentualDAOImpl;
import DAO.UserDAO;
import DAO.UserDAOImpl;
import model.Atraccion;
import model.Itinerario;
import model.PromocionAbsoluta;
import model.PromocionAxB;
import model.PromocionPorcentual;
import model.Usuario;

public class App {

	public static void main(String[] args) throws SQLException {

		System.out.println("------------------------USUARIOS---------------------");

		System.out.println("Inserto un usuario------------------------------------");
		UserDAO usuario = DAOFactory.getUserDAO();

		/*
		 * usuario.insert(new Usuario("Eowyn", 10.00, 8.00, 1)); usuario.insert(new
		 * Usuario("Gandalf", 100.00, 5.00, 3)); usuario.insert(new Usuario("Sam",
		 * 36.00, 8.00, 2)); usuario.insert(new Usuario("Galadriel", 120.00, 5.00, 3));
		 * Usuario p = new Usuario("Juan", 120.00, 5.00, 3); usuario.insert(p);
		 */

		System.out.println("lo encuentro y lo cuento------------------------------------");
		System.out.println(usuario.findAll());
		System.out.println(usuario.countAll());

		System.out.println("lo convierto en objeto---------------------------------");

		System.out.println(usuario.getUsuaries());

		System.out.println("------------------------ATRACCION---------------------");

		System.out.println("------------------------creo atracciones y las inserto---------------------");

		AtraccionDAO atrcc = DAOFactory.getAtraccionDAO();
		/*
		 * atrcc.insert(new Atraccion("Moria", 10.00, 2.00, 6, 1)); atrcc.insert(new
		 * Atraccion("Minas Tirith", 5.00, 2.50, 25, 3)); atrcc.insert(new
		 * Atraccion("La Comarca", 3.00, 6.5, 150, 2)); atrcc.insert(new
		 * Atraccion("Mordor", 25.00, 3.00, 4, 1)); atrcc.insert(new
		 * 
		 * Atraccion("Abismo de Helm", 5.00, 2.00, 15, 3)); atrcc.insert(new
		 * Atraccion("Lothórien", 35.00, 1.00, 30, 2)); atrcc.insert(new
		 * Atraccion("Erebor", 12.00, 3.00, 32, 3)); atrcc.insert(new
		 * Atraccion("Bosque Negro", 3.00, 4.00, 12, 1));
		 */

		System.out.println("------------------------las traigo todas de la base de datos---------------------");
		System.out.println(atrcc.findAll());

		System.out.println("--------------------ahora las convierto en objeto---------------------");
		System.out.println(atrcc.getAtracciones());
		/*
		 * System.out.println("le resto un cupo a la atraccion " +
		 * atrcc.getAtracciones().get(1).getNombre());
		 * System.out.println("su cupo inicial es de " +
		 * atrcc.getAtracciones().get(1).getCupo()); System.out.println("su id es " +
		 * atrcc.getAtracciones().get(1).getId());
		 * 
		 * int idDeAtraccion; idDeAtraccion = atrcc.getAtracciones().get(1).getId();
		 * System.out.println(" le resto un cupo a la atracccion");
		 * atrcc.restarCupo(idDeAtraccion);
		 * System.out.println("el cupo de la atraccion ahora es" +
		 * atrcc.getAtracciones().get(1).getCupo());
		 */
		/* System.out.println(atrcc.findAll()); */

		System.out.println("------------------------PROMOCIONES---------------------");

		System.out.println("------probamos insertar una promocion porcentual-----");
		PromocionPorcentualDAO nuevaPorcentual = DAOFactory.getPromocionesPorcentuales();
		System.out.println(nuevaPorcentual.findAll());
		System.out.println(nuevaPorcentual.getPromocionesPorcentuales());

		/*
		 * System.out.println("restamos cupo de la promocion");
		 * 
		 * System.out.println(atrcc.getAtracciones()); int id_promo =
		 * nuevaPorcentual.getPromocionesPorcentuales().get(1).getId();
		 * nuevaPorcentual.restarCupoPromocion(id_promo);
		 * 
		 * atrcc.restarCupo(1);
		 * 
		 * System.out.println(atrcc.getAtracciones());
		 * 
		 * System.out.println("su id es " + id_promo);
		 * 
		 * nuevaPorcentual.restarCupoPromocion(id_promo);
		 * System.out.println(atrcc.getAtracciones());
		 * 
		 * nuevaPorcentual.insert(new PromocionPorcentual("pack Aventura", 8, 3, 0,
		 * 20.00, 0, 1, 5)); nuevaPorcentual.insert(new
		 * PromocionPorcentual("pack Aventura Mediterranea", 8, 3, 0, 20.00, 0, 1, 5));
		 * 
		 * System.out.println("ahora traemos todo -----------------------");
		 * System.out.println(nuevaPorcentual.findAll());
		 * 
		 * System.out.
		 * println("aun no lo convierto en objeto (work in progress)---------------------------------"
		 * ); nuevaPorcentual.getPromocionesPorcentuales();
		 * System.out.println(nuevaPorcentual.getPromocionesPorcentuales());
		 * 
		 * System.out.
		 * println("------probamos insertar una promocion axb-----------------");
		 * 
		 * PromocionAxBDAO nuevaAxB = DAOFactory.getPromocionesAxBs();
		 * nuevaAxB.insert(new PromocionAxB("pack Paisaje", 2, 5, 7, 0.00, 0.00, 3, 5));
		 * nuevaAxB.insert(new PromocionAxB("pack Aventura + 1 gratis", 1, 4, 8, 0.00,
		 * 0.00, 1, 5));
		 * 
		 * System.out.
		 * println("ahora traemos la promocion axb------------------------------------------"
		 * ); System.out.println(nuevaAxB.findAll());
		 * 
		 * System.out.
		 * println("no convierto en objeto porque work in progres------------------------------"
		 * ); System.out.println(nuevaAxB.getPromocionesAxB());
		 * 
		 * System.out.
		 * println("hago una promo absoluta ------------------------------------------------"
		 * );
		 * 
		 * PromocionAbsolutaDAO nuevaAbs = DAOFactory.getPromocionesAbsolutas();
		 * nuevaAbs.insert(new PromocionAbsoluta("Pack ", 6, 3, 0.00, 36.00, 2, 2)); //
		 * nuevaAbs.insert(new PromocionAbsoluta("Pack Degustacion1", 6, 3, 0.00, 36.00,
		 * // 2, 2));
		 * 
		 * System.out.
		 * println("------inserta la promocion Abs, ahora a ver si la trae-----");
		 * System.out.println(nuevaAbs.findAll());
		 * 
		 * System.out.
		 * println("no convierto en objeto porque work in progres------------------------------"
		 * ); System.out.println(nuevaAbs.getPromocionesAbsolutas());
		 * 
		 * System.out.
		 * println("------------------------ESTO FUNCIONA HERMOSAMENTE!--------------------"
		 * );
		 */

	}
}
