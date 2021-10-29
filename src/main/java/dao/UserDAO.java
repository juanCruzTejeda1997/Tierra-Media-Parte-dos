package DAO;



import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import model.Usuario;

public interface  UserDAO extends GenericDAO<Usuario> {
	public Usuario findByUsername(String usuario);

	public List<Usuario> findAll();

	public int countAll();

	public int insert(Usuario t) throws SQLException;

	public int update(Usuario t) throws SQLException;

	public int delete(Usuario t);
	
	public LinkedList<Usuario> getUsuarios();
}
