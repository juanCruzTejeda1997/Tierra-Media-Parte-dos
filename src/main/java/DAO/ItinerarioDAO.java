package DAO;

import java.util.LinkedList;

import model.Atraccion;
import model.Itinerario;
import model.PromocionAbsoluta;
import model.PromocionAxB;
import model.PromocionPorcentual;
import model.Usuario;

public interface ItinerarioDAO extends GenericDAO<Object> {
	public int insertAtraccion(Atraccion atraccion, Usuario usuario);
	public int insertPromocionPorcentual(PromocionPorcentual promocion, Usuario usuario);
	public int insertPromocionAxB(PromocionAxB promocion, Usuario usuario);
	public int insertPromocionAbsoluta(PromocionAbsoluta promocion, Usuario usuario);
	public LinkedList<Itinerario> buscarItinerarioPorUsuario(String nombre);
	
}
