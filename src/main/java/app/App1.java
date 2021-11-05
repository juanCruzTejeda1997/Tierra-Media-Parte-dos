package app;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.Scanner;

import DAO.AtraccionDAO;
import DAO.DAOFactory;
import DAO.ItinerarioDAOImpl;
import DAO.PromocionAbsolutaDAOImpl;
import DAO.PromocionAxBDAOImpl;
import DAO.PromocionPorcentualDAOImpl;
import DAO.UserDAOImpl;
import model.Atraccion;
import model.Producto;
import model.Promocion;
import model.PromocionAbsoluta;
import model.PromocionAxB;
import model.PromocionPorcentual;
import model.Usuario;


public class App1 {

	private LinkedList<Producto> productosDeTierraMedia = new LinkedList<Producto>();
	private LinkedList<Usuario> usuarios = new LinkedList<Usuario>();
	private LinkedList<Atraccion> atraccionesTM = new LinkedList<Atraccion>();
	private LinkedList<PromocionAbsoluta> promocionesA_TM = new LinkedList<PromocionAbsoluta>();
	private LinkedList<PromocionAxB> promocionesAxB_TM = new LinkedList<PromocionAxB>();
	private LinkedList<PromocionPorcentual> promocionesP_TM = new LinkedList<PromocionPorcentual>();

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
		
		
		
		

		this.productosDeTierraMedia = productosDeTierraMedia;
		this.usuarios = usuarios;
	}

	@SuppressWarnings("static-access")
	public static void main(String[] args) throws SQLException {
		AtraccionDAO atrcc = DAOFactory.getAtraccionDAO();
		
		App1 nuevaApp = new App1();

		nuevaApp.cargaDatos();
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		String respuesta;
		for (Usuario usuario : nuevaApp.getUsuarios()) {

			ItinerarioDAOImpl it = new ItinerarioDAOImpl();

			usuario.listaDePreferencias(nuevaApp.getProductosDeTierraMedia(), usuario.getTipo_preferencia());
			for (Producto producto : nuevaApp.getProductosDeTierraMedia()) {

				if (producto.getCosto() <= usuario.getPresupuesto()) {

					if (producto.getCupo() >= 1) {
						if (producto.getTiempo() <= usuario.getTiempoDisponible()) {

							System.out.println(
									usuario.getNombre() + " Desea aceptar el siguiente producto? " + producto + "Y/N");
							respuesta = sc.next();

							if (respuesta.toUpperCase().equals("Y")) {
								
								
								for (Atraccion atraccion : nuevaApp.atraccionesTM) {
									if (atraccion.getNombre().equalsIgnoreCase(producto.getNombre())) {
										it.insertAtraccion(atraccion, usuario);
										atraccion.restarCupo();
										atrcc.update(atraccion);

									}
								}

								for (PromocionAxB promocionAxB : nuevaApp.promocionesAxB_TM) {
									if (promocionAxB.getNombre().equalsIgnoreCase(producto.getNombre())) {
										it.insertPromocionAxB(promocionAxB, usuario);
										promocionAxB.restarCupo();

									}
								}

								for (PromocionAbsoluta promocionAbsoluta : nuevaApp.promocionesA_TM) {
									if (promocionAbsoluta.getNombre().equalsIgnoreCase(producto.getNombre() )) {
										it.insertPromocionAbsoluta(promocionAbsoluta, usuario);
										promocionAbsoluta.restarCupo();
										
									}
								}

								for (PromocionPorcentual promocionPorcentual : nuevaApp.promocionesP_TM) {
									if (promocionPorcentual.getNombre().equalsIgnoreCase(producto.getNombre())) {
										it.insertPromocionPorcentual(promocionPorcentual, usuario);
										promocionPorcentual.restarCupo();
									}
								}

								usuario.restarPresupuesto(producto.getCosto());
							
								
								usuario.restarTiempo(producto.getTiempo());
								
								System.out.println(
										"Ha comprado el producto " + producto.getNombre() + " , " + producto.getNombre()
												+ " contiene ahora " + producto.getCupo() + " lugares disponibles");
							}

							// usuario.agregarProducto(producto);

						}
					}
				}

			}

		}
	}
}
