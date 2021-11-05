package DAO;

import java.sql.SQLException;
import java.util.ArrayList;

import model.Atraccion;

public interface AtraccionDAO extends GenericDAO<Atraccion>{
	public abstract Atraccion buscarAtraccionPorNombre(String nombre);
	public ArrayList<Atraccion> getAtracciones();
	public abstract void restarCupo(int i) throws SQLException;
	
}

