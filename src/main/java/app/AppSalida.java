package app;

import java.sql.SQLException;
import java.util.ArrayList;
import model.tipo_producto;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import DAO.AtraccionDAO;
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
import model.Producto;
import model.Promocion;
import model.PromocionAbsoluta;
import model.PromocionAxB;
import model.PromocionPorcentual;
import model.Usuario;


public class AppSalida {

public static class App1 {
	


	private static LinkedList<Producto> productosDeTierraMedia = new LinkedList<Producto>();
	private LinkedList<Usuario> usuarios = new LinkedList<Usuario>();
	private LinkedList<Atraccion> atraccionesTM = new LinkedList<Atraccion>();
	private LinkedList<PromocionAbsoluta> promocionesA_TM = new LinkedList<PromocionAbsoluta>();
	private LinkedList<PromocionAxB> promocionesAxB_TM = new LinkedList<PromocionAxB>();
	private LinkedList<PromocionPorcentual> promocionesP_TM = new LinkedList<PromocionPorcentual>();
	private LinkedList<Producto> productos_it = new LinkedList<Producto>();

	public LinkedList<Producto> getProductosDeTierraMedia() {
		return productosDeTierraMedia;
	}

	public LinkedList<Usuario> getUsuarios() {
		return usuarios;
	}

	public void cargaDatos() {


		AtraccionDAO atrcc = DAOFactory.getAtraccionDAO();
		PromocionAbsolutaDAOImpl prA = DAOFactory.getPromocionesAbsolutas();
		PromocionAxBDAOImpl prAxB = DAOFactory.getPromocionesAxBs();
		PromocionPorcentualDAOImpl prP = DAOFactory.getPromocionesPorcentuales();
		UserDAOImpl uDao = DAOFactory.getUserDAO();
		// cargoMisUsuarios
		usuarios = uDao.getUsuaries();
		// tomo de mi base de datos las atracciones

		this.atraccionesTM = atrcc.getAtracciones();

		// tomo de mi base de datos las promociones

		this.promocionesA_TM = prA.getPromocionesAbsolutas(atraccionesTM);

		this.promocionesP_TM = prP.getPromocionesPorcentuales(atraccionesTM);

		this.promocionesAxB_TM = prAxB.getPromocionesAxB(atraccionesTM);

		// agrego mis productos a mi lista de productos
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
		
		
	}
	
	public LinkedList<Producto> itinerarioToProducto(LinkedList<Itinerario> it){
		Atraccion a = null;
		PromocionPorcentual pp = null;
		PromocionAxB paxb = null;
		PromocionAbsoluta pa = null;
		
		for (Itinerario item : it) {
			if (item.getTipoProducto().equals(tipo_producto.ATRACCION)) {
				a = item.getAtraccion();
				productos_it.add(a);
			} else if (item.getTipoProducto().equals(tipo_producto.PORCENTUAL)) {
				pp = item.getPromocionPorcentual();
				productos_it.add(pp);
			} else if (item.getTipoProducto().equals(tipo_producto.AxB)) {
				paxb = item.getPromocionAxB();
				productos_it.add(paxb);
			} else if (item.getTipoProducto().equals(tipo_producto.ABSOLUTA)){
				pa = item.getPromocionAbsoluta();
				productos_it.add(pa);
			}
		}
		return productos_it;
	}
	
	
	@SuppressWarnings("static-access")
	public static void main(String[] args) throws SQLException {
		App1 nuevaApp = new App1();

		nuevaApp.cargaDatos();
		Scanner sc = new Scanner(System.in);
		String respuesta;
		for (Usuario usuario : nuevaApp.getUsuarios()) {

			ItinerarioDAOImpl it = new ItinerarioDAOImpl();
			try {
				try {
					try {
						productosDeTierraMedia = nuevaApp.getProductosDeTierraMedia();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			LinkedList<Itinerario> itinerario = it.buscarItinerarioPorUsuario(usuario.getNombre());
			System.out.println(itinerario);// << creo que buscarItinerarioPorUsuario no trae el itinerario del usuario solo, sino de todos. Verificar la consulta sql
			productos_it = nuevaApp.itinerarioToProducto(itinerario);
			boolean contiene = false;
			
			Usuario.listaDePreferencias(productosDeTierraMedia, usuario.getTipo_preferencia());
			
			for (Producto producto : productosDeTierraMedia) {
				
				if (productos_it.contains(producto)) {
					System.out.println("contiene");
					contiene = true;
				}
				
				if (producto.getCosto() <= usuario.getPresupuesto()) {

					if (producto.getCupo() >= 1 && !contiene) {
						if (usuario.getTiempoDisponible() >= producto.getTiempo() && usuario.getPresupuesto() >= producto.getCosto()) {

							System.out.println(
									usuario.getNombre() + " Desea aceptar el siguiente producto? " + producto + "Y/N");
							respuesta = sc.next();

							if (respuesta.toUpperCase().equals("Y")) {

								for (Atraccion atraccion : nuevaApp.atraccionesTM) {
									if (atraccion.getNombre().equalsIgnoreCase(producto.getNombre())) {
										it.insertAtraccion(atraccion, usuario);
										itinerario = it.buscarItinerarioPorUsuario(usuario.getNombre());
										productos_it.add(atraccion);
									}
								}

								for (PromocionAxB promocionAxB : nuevaApp.promocionesAxB_TM) {
									if (promocionAxB.getNombre().equalsIgnoreCase(producto.getNombre())) {
										it.insertPromocionAxB(promocionAxB, usuario);
										itinerario = it.buscarItinerarioPorUsuario(usuario.getNombre());
										productos_it.add(promocionAxB);
									}
								}

								for (PromocionAbsoluta promocionAbsoluta : nuevaApp.promocionesA_TM) {
									if (promocionAbsoluta.getNombre().equalsIgnoreCase(producto.getNombre())) {
										it.insertPromocionAbsoluta(promocionAbsoluta, usuario);
										itinerario = it.buscarItinerarioPorUsuario(usuario.getNombre());
										productos_it.add(promocionAbsoluta);
									}
								}

								for (PromocionPorcentual promocionPorcentual : nuevaApp.promocionesP_TM) {
									if (promocionPorcentual.getNombre().equalsIgnoreCase(producto.getNombre())) {
										it.insertPromocionPorcentual(promocionPorcentual, usuario);
										itinerario = it.buscarItinerarioPorUsuario(usuario.getNombre());
										productos_it.add(promocionPorcentual);
									}
								}

								producto.restarCupo();
								usuario.restarPresupuesto(producto.getCosto());
								System.out.println(usuario.getPresupuesto());
								usuario.restarTiempo(producto.getTiempo());
								System.out.println(usuario.getTiempoDisponible());
								System.out.println(producto.getTiempo());

								System.out.println(
										"Ha comprado el producto " + producto.getNombre() + " , " + producto.getNombre()
												+ " contiene ahora " + producto.getCupo() + " lugares disponibles");
							}

							// usuario.agregarProducto(producto);

						}
					}
				}
				contiene = false;
			}
			System.out.println(
					"El itinerario de " + usuario.getNombre() + " es " + itinerario + " gastó en total: "
							+ usuario.gastoTotal() + " monedas, y le llevará " + usuario.gastoTotalTiempo() + " horas.");
		}
	}



}
}