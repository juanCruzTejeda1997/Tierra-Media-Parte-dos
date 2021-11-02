package dao;

import java.util.LinkedList;

import model.Itinerario;

public interface ItinerarioDAO extends GenericDAO<Itinerario> {
	
		public abstract Itinerario buscarItinerarioPorNombre(String nombre);
		public LinkedList<Itinerario> buscarItinerarioPorUsuario(String nombre);
		
	

}
