package app;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

import DAO.AtraccionDAO;
import DAO.AtraccionDAOImpl;
import DAO.DAOFactory;
import DAO.ItinerarioDAOImpl;
import DAO.PromocionAbsolutaDAO;
import DAO.PromocionAbsolutaDAOImpl;
import DAO.PromocionAxBDAOImpl;
import DAO.PromocionDAO;
import DAO.PromocionPorcentualDAO;
import DAO.PromocionPorcentualDAOImpl;
import DAO.UserDAOImpl;
import model.*;


public class App1 {

	private LinkedList<Producto> productosDeTierraMedia = new LinkedList<Producto>();
	private LinkedList<Usuario> usuarios = new LinkedList<Usuario>();
	private ArrayList<Atraccion> atraccionesTM = new ArrayList<Atraccion>();
	private LinkedList <PromocionAbsoluta> promocionesA_TM = new LinkedList <PromocionAbsoluta>();
	private LinkedList<PromocionAxB> promocionesAxB_TM = new LinkedList<PromocionAxB>();
	private LinkedList<PromocionPorcentual> promocionesP_TM = new LinkedList <PromocionPorcentual>();
	public LinkedList<Producto> getProductosDeTierraMedia() {
		return productosDeTierraMedia;
	}

	public LinkedList<Usuario> getUsuarios() {
		return usuarios;
	}
   public void cargaDatos(){
		
		AtraccionDAO atrcc = DAOFactory.getAtraccionDAO();
		PromocionAbsolutaDAOImpl prA = DAOFactory.getPromocionesAbsolutas();
		PromocionAxBDAOImpl prAxB = DAOFactory.getPromocionesAxBs();
		PromocionPorcentualDAOImpl prP =  DAOFactory.getPromocionesPorcentuales();
		UserDAOImpl uDao = DAOFactory.getUserDAO();
		//cargoMisUsuarios
		usuarios = uDao.getUsuaries();
		//tomo de mi base de datos las atracciones
		
		this.atraccionesTM = atrcc.getAtracciones();
		
		//tomo de mi base de datos las promociones
		
		this.promocionesA_TM = prA.getPromocionesAbsolutas();
		
		
		this.promocionesP_TM  = prP.getPromocionesPorcentuales();
		
		
		
		this.promocionesAxB_TM= prAxB.getPromocionesAxB();
		
		 //agrego mis productos a mi lista de productos
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
	public static  void main(String[] args) throws SQLException {
		App1 nuevaApp = new App1();
		
		nuevaApp.cargaDatos();
		Scanner sc = new Scanner(System.in);
		String respuesta;
		for (Usuario usuario : nuevaApp.getUsuarios()) {

			ItinerarioDAOImpl it = new ItinerarioDAOImpl();
			
			
			
			usuario.listaDePreferencias(nuevaApp.getProductosDeTierraMedia(), usuario.getTipo_preferencia());
			for (Producto producto : nuevaApp.getProductosDeTierraMedia()) {
				if(producto.getCosto()<= usuario.getPresupuesto()) {
					
					if (producto.getCupo()>=1) {
						if(producto.getTiempo()<= usuario.getTiempoDisponible()) {
							
							
						
							System.out.println( usuario.getNombre() + " Desea aceptar el siguiente producto? " +
							producto + " que tiene " + producto.getCupo() + " disponible?" + "Y/N" );
							respuesta = sc.next();
							
							
 								if (respuesta.toUpperCase().equals("Y")) {
 									
 									for (Atraccion atraccion : nuevaApp.atraccionesTM) {
 										if(atraccion.getNombre().equalsIgnoreCase(producto.getNombre())){
 											it.insertAtraccion(atraccion, usuario);
 										}
 									}
 									
 									for (PromocionAxB promocionAxB : nuevaApp.promocionesAxB_TM) {
 										if(promocionAxB.getNombre().equalsIgnoreCase(producto.getNombre())) {
 											it.insertPromocionAxB(promocionAxB, usuario);
 										}
 									}
 									
 									for (PromocionAbsoluta promocionAbsoluta : nuevaApp.promocionesA_TM) {
 										if(promocionAbsoluta.getNombre().equalsIgnoreCase(producto.getNombre())) {
 											it.insertPromocionAbsoluta(promocionAbsoluta, usuario);
 										}
 									}
 									
 									for (PromocionPorcentual promocionPorcentual : nuevaApp.promocionesP_TM) {
 										if(promocionPorcentual.getNombre().equalsIgnoreCase(producto.getNombre())) {
 											it.insertPromocionPorcentual(promocionPorcentual, usuario);
 										}
 									}

 									producto.restarCupo();
 								   usuario.restarPresupuesto(producto.getCosto());
 								   System.out.println(usuario.getPresupuesto());
 								   usuario.restarTiempo(producto.getTiempo());
 								   System.out.println(usuario.getTiempoDisponible());
 										
 									System.out.println(
 												"Ha comprado el producto " + producto.getNombre() + " , " + producto.getNombre()
 												+ " contiene ahora " + producto.getCupo() + " lugares disponibles");
 								}
								

									//usuario.agregarProducto(producto);
                                
									

								
							
						}
						}
	                   }
	 
				}
				
					}
				}
			}
		
		
	

	

	





		
	
