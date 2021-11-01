package DAO;

import java.sql.SQLException;
import java.util.ArrayList;

import model.Atraccion;
import model.Itinerario;

public interface ItinerarioDAO {
	
		public abstract Itinerario buscarItinerarioPorid(int id);
		public ArrayList<Itinerario> getItinerario();
		
}
