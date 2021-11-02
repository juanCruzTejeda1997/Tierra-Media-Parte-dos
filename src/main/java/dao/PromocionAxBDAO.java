package dao;

import java.util.LinkedList;

import model.PromocionAxB;

public interface PromocionAxBDAO extends GenericDAO<PromocionAxB> {
	
	public  LinkedList<PromocionAxB> getPromocionesAxB();
	
}
