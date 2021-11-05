package DAO;

import java.util.LinkedList;

import model.Atraccion;
import model.PromocionPorcentual;


public interface PromocionPorcentualDAO extends GenericDAO<PromocionPorcentual> {
	public  LinkedList<PromocionPorcentual> getPromocionesPorcentuales (LinkedList<Atraccion> atracciones);
    public abstract void restarCupoPromocion(int t); 
    }
