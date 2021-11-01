package DAO;

import java.util.LinkedList;

import model.PromocionAbsoluta;


public interface PromocionAbsolutaDAO extends GenericDAO <PromocionAbsoluta> {
	public  LinkedList<PromocionAbsoluta> getPromocionesAbsolutas();

}