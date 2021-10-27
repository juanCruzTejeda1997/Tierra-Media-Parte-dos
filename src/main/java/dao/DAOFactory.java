package DAO;



public class DAOFactory {


		public static UserDAOImpl getUserDAO() {
			return new UserDAOImpl();
		}

		public static AtraccionDAOImpl getAtraccionDAO() {
			return new AtraccionDAOImpl();
			
		}
		
	

}
