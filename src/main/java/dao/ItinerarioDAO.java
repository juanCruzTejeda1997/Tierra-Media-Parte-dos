package dao;

import model.Itinerario;

public interface ItinerarioDAO extends GenericDAO<Itinerario> {
	
		public abstract Itinerario buscarItinerarioPorNombre(String nombre);
		
	

}
