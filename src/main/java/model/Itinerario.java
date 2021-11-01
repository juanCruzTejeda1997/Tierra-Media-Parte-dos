package model;

import java.lang.reflect.Array;
import java.util.LinkedList;

public class Itinerario {
 private int id;
 private int atraccion_id;
 private int promocionPorcentual_id;
 private int promocionAbsoluta_id;
 private int promocionAxB_id;
 private int usuario_id;
private Atraccion atraccion;
private PromocionPorcentual promocionPorcentual;
private PromocionAbsoluta promocionAbsoluta;
private PromocionAxB promocionAxB;
private LinkedList<Producto> productosComprados ;    
private Usuario usuario;    

	
	
	public Itinerario(int id, int atraccion_id, int promocionPorcentual_id, int promocionAbsoluta_id, int promocionAxB_id,
		int usuario_id) {
	super();
	this.id = id;
	this.atraccion_id = atraccion_id;
	this.promocionPorcentual_id = promocionPorcentual_id;
	this.promocionAbsoluta_id = promocionAbsoluta_id;
	this.promocionAxB_id = promocionAxB_id;
	this.usuario_id = usuario_id;
}

	
	
	/*public Itinerario(int id, Atraccion atraccion, PromocionPorcentual promocionPorcentual, PromocionAbsoluta promocionAbsoluta, PromocionAxB promocionAxB,
			int usuario_id) {
		super();
		this.id = id;
		this.atraccion = atraccion;
		this.promocionPorcentual = promocionPorcentual;
		this.promocionAbsoluta = promocionAbsoluta;
		this.promocionAxB= promocionAxB;
		this.usuario_id = usuario_id;
	}*/


	
	
	
	public Itinerario(LinkedList<Producto> productosComprados, Usuario usuario) {
		super();
		this.productosComprados = productosComprados;
		this.usuario = usuario;
	}

	public int getId() {
	return id;
}


public Atraccion getAtraccion() {
		return atraccion;
	}

	public PromocionPorcentual getPromocionPorcentual() {
		return promocionPorcentual;
	}

	public PromocionAbsoluta getPromocionAbsoluta() {
		return promocionAbsoluta;
	}

	public PromocionAxB getPromocionAxB() {
		return promocionAxB;
	}

public int getAtraccion_id() {
	return atraccion_id;
}


public int getPromocionPorcentual_id() {
	return promocionPorcentual_id;
}


public int getPromocionAbsoluta_id() {
	return promocionAbsoluta_id;
}


public int getPromocionAxB_id() {
	return promocionAxB_id;
}


public int getUsuario_id() {
	return usuario_id;
}

public LinkedList<Producto> getProductosComprados() {
		return productosComprados;
	}
    
	

	
public boolean contieneProducto (Producto producto) {
		return productosComprados.contains(producto);
	}

public String toString() {
return "el itinerario de "+ this.usuario.getNombre() + " contiene los siguientes productos "+ this.getProductosComprados();

}


}
