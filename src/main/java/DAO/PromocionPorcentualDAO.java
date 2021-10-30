package DAO;

import java.util.LinkedList;

import model.PromocionPorcentual;


public interface PromocionPorcentualDAO extends GenericDAO<PromocionPorcentual> {
	public  LinkedList<PromocionPorcentual> getPromocionesPorcentuales ();
}
