package app;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import DAO.AtraccionDAO;
import DAO.DAOFactory;
import DAO.PromocionAbsolutaDAO;
import DAO.PromocionAxBDAO;
import DAO.PromocionPorcentualDAO;
import DAO.UserDAO;
import model.Atraccion;
import model.Producto;
import model.Promocion;
import model.PromocionAbsoluta;
import model.PromocionAxB;
import model.PromocionPorcentual;
import model.Usuario;


public class AppSalida {

	private static HashMap<String, ArrayList<Producto>> dicUsuarios = new HashMap();

	private LinkedList<Usuario> usuarios;
	private static ArrayList<Producto> productos = new ArrayList<Producto>();
	static App app;

	private static void cargaDatos(App app) {
		ArrayList<Atraccion> atracciones = new ArrayList<Atraccion>();
		LinkedList<PromocionPorcentual> promocionesPorc = new LinkedList<PromocionPorcentual>();
		LinkedList<PromocionAxB> promocionesAxB = new LinkedList<PromocionAxB>();
		LinkedList<PromocionAbsoluta> promocionesAbs = new LinkedList<PromocionAbsoluta>();
		

		UserDAO LectorU = DAOFactory.getUserDAO();
		app.usuarios = LectorU.getUsuaries();
		AtraccionDAO lectorA = DAOFactory.getAtraccionDAO();
		atracciones = lectorA.getAtracciones();
		PromocionPorcentualDAO lectorPorcentual = DAOFactory.getPromocionesPorcentuales();
		PromocionAxBDAO lectorAxB = DAOFactory.getPromocionesAxBs();
		PromocionAbsolutaDAO lectorAbsoluto = DAOFactory.getPromocionesAbsolutas();
		promocionesPorc = lectorPorcentual.getPromocionesPorcentuales();
		promocionesAxB = lectorAxB.getPromocionesAxB();
		promocionesAbs = lectorAbsoluto.getPromocionesAbsolutas();

		for (Atraccion atraccion : atracciones) {
			app.productos.add(atraccion);
		}

		for (Promocion promocion : promocionesPorc) {
			app.productos.add(promocion);
		}
		for (Promocion promocion : promocionesAxB) {
			app.productos.add(promocion);
		}
		for (Promocion promocion : promocionesAbs) {
			app.productos.add(promocion);
		}
	}

	public static void main(String[] args) throws Exception {
		app = new App();
		cargaDatos(app);
		RegistroUsuarios r = new RegistroUsuarios();
		
		Scanner sc = new Scanner(System.in);
		String respuesta;

		for (Usuario usuario : app.usuarios) {

			System.out.println(usuario);
			usuario.crearItinerario();
			usuario.listaDePreferencias(productos, usuario.getPreferencia());
			for (Producto producto : productos) {
				ArrayList<Producto> itinerario = usuario.getItinerario();
				boolean contiene = false;
				Iterator<Producto> itr = itinerario.iterator();
				while (!contiene && itr.hasNext()) {
					contiene = itr.next().contiene(producto);
				}
				if (producto.tieneCupo() && !contiene) {
					if (usuario.getTiempoDisponible() >= producto.getTiempo() && usuario.getPresupuesto() >= producto.getCosto()) {
						do {
							System.out.println("Desea aceptar el siguiente producto? " + producto + " Y/N");
							respuesta = sc.next();
						} while ((!respuesta.toUpperCase().equals("Y")) && (!respuesta.toUpperCase().equals("N")));
						if (respuesta.toUpperCase().equals("Y")) {
							

								usuario.agregarProducto(producto);

								producto.restarCupo();
								
								System.out.println(
										"Ha comprado el producto " + producto.getNombre() + " , " + producto.getNombre()
										+ " contiene ahora " + producto.getCupo() + " lugares disponibles");
						}
					}
				}
			}
			
			dicUsuarios.put(usuario.getNombre(), usuario.getItinerario());
			
			ArrayList<String> ItinerarioFinalNombres = new ArrayList<String>();
			for (int i = 0; i < usuario.getItinerario().size(); i++) {
				String nombre = usuario.getItinerario().get(i).getNombre();
				ItinerarioFinalNombres.add(nombre);
			}
			r.crearRegistro(usuario.getItinerario(), usuario);
			System.out.println(
					"El itinerario de " + usuario.getNombre() + " es " + ItinerarioFinalNombres + " gastó en total: "
							+ usuario.gastoTotal() + " monedas, y gastó " + usuario.gastoTotalTiempo() + " horas.");
			System.out.println();
			System.out.println("Itinerario== " + dicUsuarios);
		}
	}
}

