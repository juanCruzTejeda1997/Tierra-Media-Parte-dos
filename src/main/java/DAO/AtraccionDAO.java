package DAO;

import java.util.ArrayList;

import model.Atraccion;

public interface AtraccionDAO extends GenericDAO<Atraccion>{
	public abstract Atraccion buscarAtraccionPorNombre(String nombre);
	public ArrayList<Atraccion> getAtracciones();
	
}