package DAO;

import java.util.LinkedList;

import model.Atraccion;
import model.PromocionAxB;



public interface PromocionAxBDAO extends GenericDAO<PromocionAxB>{
	
	public  LinkedList<PromocionAxB> getPromocionesAxB(LinkedList <Atraccion> atracciones);

}
