package app;

import java.sql.SQLException;

import dao.AtraccionDAO;
import dao.PromocionDAO;
import dao.UsuarioDAO;
import model.Atraccion;
import model.PromocionPorcentual;
import model.Usuario;

public class App {
	
	public static void main(String[] args) throws SQLException {
		System.out.println("-------------Agrego un Usuario---------------");
		
		UsuarioDAO eowyn = new UsuarioDAO();
		eowyn.insert(new Usuario("Eowyn", 10, 8, 1));
		System.out.println(eowyn.findAll());
		
		System.out.println("-------Agrego una atracción------------------");
		
		AtraccionDAO minasTirith = new AtraccionDAO();
		minasTirith.insert(new Atraccion("Minas Tirith", 3, 5, 2.5, 6));
		System.out.println(minasTirith.findAll());
		
		System.out.println("------Ahora no sé cómo hacer la promoción-----");
		PromocionDAO packAventura = new PromocionDAO();
		packAventura.insertPromocionPorcentual(new PromocionPorcentual("Pack Aventura", 1, 1, 0.2));
		System.out.println(packAventura.findAll());
	}
}
