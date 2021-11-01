package app;

import java.util.ArrayList;
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
import model.PromocionAbsoluta;
import model.PromocionAxB;
import model.PromocionPorcentual;
import model.Usuario;

public class App {

	private List<Usuario> usuarios;
	private static ArrayList<Producto> productos = new ArrayList<Producto>();
	static App app;
	
	public static void main(String[] args){
		app = new App();
		boolean flag = true;
		Scanner sc = new Scanner(System.in);
		String respuesta;
		
		menu();
		respuesta = sc.next();
		while (flag) {
			if (respuesta.equals("1")) {
				cargaDatos();
				for (Usuario usuario : app.usuarios) {
					usuario.listaDePreferencias(productos, usuario.getTipo_preferencia());
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
				}
			}
			else if (respuesta.equals("2")) {
				System.out.println("En construcción");
			}
			else if (respuesta.equals("3")) {
				System.out.println("En construcción");
			}
			else if (respuesta.equals("4")) {
				System.out.println("En construcción");
			}
			else if (respuesta.equals("5")) {
				flag = false;
			}
			else{
				System.out.println("Ingrese una opción válida");
				menu();
			}
		}
		System.out.println("Gracias por utilizar nuestros servicios de turismo. Vuelva pronto");
	}
	
	public static void menu() {
		System.out.println("Seleccione el número de la función que desea utilizar:");
		System.out.println("1 - Armar itinerario");
		System.out.println("2 - Cargar nuevo  usuario");
		System.out.println("3 - Cargar nueva atracción");
		System.out.println("4 - Cargar nueva promoción");
		System.out.println("5 - Finalizar programa");
	}
	
	private static void cargaDatos() {
		List<Atraccion> atracciones = new LinkedList<Atraccion>();
		List<PromocionAxB> promocionesAxB = new LinkedList<PromocionAxB>();
		List<PromocionAbsoluta> promocionesAbsolutas = new LinkedList<PromocionAbsoluta>();
		List<PromocionPorcentual> promocionesPorcentuales = new LinkedList<PromocionPorcentual>();

		UserDAO lectorUsuarios = DAOFactory.getUserDAO();
		app.usuarios = lectorUsuarios.getUsuaries();
		AtraccionDAO lectorAtracciones = DAOFactory.getAtraccionDAO();
		atracciones = lectorAtracciones.getAtracciones();
		PromocionAxBDAO lectorPromocionAxB = DAOFactory.getPromocionesAxBs();
		promocionesAxB = lectorPromocionAxB.getPromocionesAxB();
		PromocionAbsolutaDAO lectorPromocionAbsoluta = DAOFactory.getPromocionesAbsolutas();
		promocionesAbsolutas = lectorPromocionAbsoluta.getPromocionesAbsolutas();
		PromocionPorcentualDAO lectorPromocionPorcentual = DAOFactory.getPromocionesPorcentuales();
		promocionesPorcentuales = lectorPromocionPorcentual.getPromocionesPorcentuales();

		for (Atraccion atraccion : atracciones) {
			app.productos.add(atraccion);
		}

		for (PromocionAbsoluta promocionAbsoluta : promocionesAbsolutas) {
			app.productos.add(promocionAbsoluta);
		}
		
		for (PromocionAxB promocionAxB : promocionesAxB) {
			app.productos.add(promocionAxB);
		}
		
		for (PromocionPorcentual promocionPorcentual : promocionesPorcentuales) {
			app.productos.add(promocionPorcentual);
		}
	}
}
