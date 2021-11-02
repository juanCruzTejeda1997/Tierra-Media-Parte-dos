package model;

import java.util.LinkedList;

public class Itinerario {
	
	private int id;
	private int atraccion_id;
	private int promocion_porcentual_id;
	private int promocion_axb_id;
	private int promocion_absoluta_id;
	private int usuario_id;
	private Atraccion atraccion;
	private PromocionPorcentual promocionPorcentual;
	private PromocionAxB promocionAxB;
	private PromocionAbsoluta promocionAbsoluta;
	private Usuario usuario;
	
	public Itinerario(int id, int atraccion_id, int promocion_porcentual_id, int promocion_axb_id,
			int promocion_absoluta_id, int usuario_id) {
		this.id = id;
		this.atraccion_id = atraccion_id;
		this.promocion_porcentual_id = promocion_porcentual_id;
		this.promocion_axb_id = promocion_axb_id;
		this.promocion_absoluta_id = promocion_absoluta_id;
		this.usuario_id = usuario_id;
	}

	public Itinerario(int id, Atraccion atraccion, PromocionPorcentual promocionPorcentual, PromocionAxB promocionAxB,
			PromocionAbsoluta promocionAbsoluta, Usuario usuario) {
		this.id = id;
		this.atraccion = atraccion;
		this.promocionPorcentual = promocionPorcentual;
		this.promocionAxB = promocionAxB;
		this.promocionAbsoluta = promocionAbsoluta;
		this.usuario = usuario;
	}
	
	

	public int getId() {
		return id;
	}

	public int getAtraccion_id() {
		return atraccion_id;
	}

	public int getPromocion_porcentual_id() {
		return promocion_porcentual_id;
	}


	public int getPromocion_axb_id() {
		return promocion_axb_id;
	}

	public int getPromocion_absoluta_id() {
		return promocion_absoluta_id;
	}

	public int getUsuario_id() {
		return usuario_id;
	}
	
	

	public Atraccion getAtraccion() {
		return atraccion;
	}

	public PromocionPorcentual getPromocionPorcentual() {
		return promocionPorcentual;
	}

	public PromocionAxB getPromocionAxB() {
		return promocionAxB;
	}

	public PromocionAbsoluta getPromocionAbsoluta() {
		return promocionAbsoluta;
	}

	public Usuario getUsuario() {
		return usuario;
	}
	
	public double calcularCosto() {
		double costo = 0;
		if(atraccion != null) {
			costo = atraccion.getCosto();			
		}
		if(promocionPorcentual != null) {
			costo = promocionPorcentual.getCosto();
		}
		if(promocionAxB != null) {
			costo = promocionAxB.getCosto();
		}
		if(promocionAbsoluta != null) {
			costo = promocionAbsoluta.getCosto();
		}
		return costo;
	}
	
	public double calcularTiempo() {
		double tiempo = 0;
		if(atraccion != null) {
			tiempo = atraccion.getTiempo();			
		}
		if(promocionPorcentual != null) {
			tiempo = promocionPorcentual.getTiempo();
		}
		if(promocionAxB != null) {
			tiempo = promocionAxB.getTiempo();
		}
		if(promocionAbsoluta != null) {
			tiempo = promocionAbsoluta.getTiempo();
		}
		return tiempo;
	}
	
	@Override
	public String toString() {

		if(atraccion != null) {
			return "ATRACCION: Nombre = " + atraccion.getNombre() + ", Duración = " + atraccion.getTiempo() + ", Costo = " + atraccion.getCosto();
		}
		
		if(promocionPorcentual != null) {
			return "PACK: Nombre = " + promocionPorcentual.getNombre() + ", Duración = " + promocionPorcentual.getTiempo() + ", Costo = " + promocionPorcentual.getCosto();
		}
		
		if(promocionAxB != null) {
			return "PACK: Nombre = " + promocionAxB.getNombre() + ", Duración = " + promocionAxB.getTiempo() + ", Costo = " + promocionAxB.getCosto();
		}
		
		if(promocionAbsoluta != null) {
			return "PACK: Nombre = " + promocionAbsoluta.getNombre() + ", Duración = " + promocionAbsoluta.getTiempo() + ", Costo = " + promocionAbsoluta.getCosto();
		}
		
		return "";
		
	}

	
	

	
	
	
	
	

}
