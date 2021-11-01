package DAO;

import java.util.LinkedList;

import model.Usuario;

public interface  UserDAO extends GenericDAO<Usuario> {
	public Usuario findByUsername(String usuario);
	public  LinkedList<Usuario> getUsuaries ();

}