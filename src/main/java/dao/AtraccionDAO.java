package DAO;

import model.Atraccion;

public interface AtraccionDAO extends GenericDAO<Atraccion>{
	public abstract Atraccion buscarAtraccionPorNombre(String nombre);
	
}

