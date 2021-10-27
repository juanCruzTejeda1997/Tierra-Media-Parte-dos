package DAO;

import model.Promocion;

public interface PromocionDAO extends GenericDAO<Promocion> {
	public abstract Promocion buscarPromocionPorNombre(String nombre);
}
