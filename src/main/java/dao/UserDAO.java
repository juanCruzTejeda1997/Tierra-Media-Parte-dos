package dao;

import model.Usuario;

public interface UserDAO  extends GenericDAO<Usuario>{

	public abstract Usuario findByUsername(String usuario);
	
	
	
	
	
}
