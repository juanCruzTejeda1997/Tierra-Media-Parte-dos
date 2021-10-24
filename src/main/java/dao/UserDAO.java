package dao;

public interface UserDAO  extends GenericDAO<Usuario>{

	public abstract Usuario findByUsername(String usuario);
	
	
	
	
	
}
