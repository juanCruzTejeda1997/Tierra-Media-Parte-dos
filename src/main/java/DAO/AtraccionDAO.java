package DAO;

import java.sql.SQLException;

import java.util.LinkedList;

import model.Atraccion;

public interface AtraccionDAO extends GenericDAO<Atraccion>{
	public abstract Atraccion buscarAtraccionPorNombre(String nombre);
	public LinkedList<Atraccion> getAtracciones();
	public abstract void restarCupo(int i) throws SQLException;
	
}

