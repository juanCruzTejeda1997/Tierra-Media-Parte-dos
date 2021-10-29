package DAO;



public class DAOFactory {


		public static UserDAOImpl getUserDAO() {
			return new UserDAOImpl();
		}

		public static AtraccionDAOImpl getAtraccionDAO() {
			return new AtraccionDAOImpl();
			
		}
		
		public static PromocionPorcentualDAOImpl getPromocionesPorcentuales() {
			return new PromocionPorcentualDAOImpl();
		}
		
		public static PromocionAxBDAOImpl getPromocionesAxBs() {
			return new PromocionAxBDAOImpl();
		}
		 public static PromocionAbsolutaDAOImpl getPromocionesAbsolutas() {
			 return new PromocionAbsolutaDAOImpl();
		 }
	

}
