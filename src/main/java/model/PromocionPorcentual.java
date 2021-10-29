package model;



public class PromocionPorcentual extends Promocion{
	
	private double descuento;	
	
	


	public PromocionPorcentual(int id, String nombre, int atraccion1_id, int atraccion2_id, double tiempo, double costo,
			int tipo_id, double descuento) {
		super(id, nombre, atraccion1_id, atraccion2_id, tiempo, costo, tipo_id);
		this.descuento = descuento;
	}

	
	

	public PromocionPorcentual(int id, String nombre, int atraccion1_id, int atraccion2_id, double tiempo, double costo,
			int tipo_id) {
		super(id, nombre, atraccion1_id, atraccion2_id, tiempo, costo, tipo_id);
		// TODO Auto-generated constructor stub
	}




	@Override
	public String toString() {
		return " id: " + super.getId() + " Nombre: " + super.getNombre() + " atracción 1 ID: " + super.getAtraccion1_id() +
				" atracción 2 ID: " + super.getAtraccion2_id() + " Tipo id : " + super.getTipo_id() + " Descuento : "+ getDescuento() +
				" costo: " + super.getCosto();

	}


	public double getDescuento() {
		return this.descuento;
	}
	
	
	}

