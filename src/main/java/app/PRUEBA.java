package app;

import java.sql.SQLException;

import DAO.ItinerarioDAOImpl;
import model.Atraccion;
import model.Usuario;

public class PRUEBA {

	public static void main(String[] args) throws SQLException {
		
		ItinerarioDAOImpl it = new ItinerarioDAOImpl();
	
		Atraccion at = new Atraccion(1,"Moria",10.0,2.0,6,1);
		
		Usuario u = new Usuario("Eowyn",1000.0,1000.0,1);
		it.insertAtraccion(at, u);
		
		System.out.println(it);
	}
}
