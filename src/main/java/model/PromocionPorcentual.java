package model;



public class PromocionPorcentual extends Promocion{
	
	private double descuento;	
	
	public PromocionPorcentual(int id, String nombre, int atraccion1_id, int atraccion2_id, double tiempo,
			double descuento, double costo, int tipo_id) {
		super(id, nombre, atraccion1_id, atraccion2_id, tiempo, costo, tipo_id);
		this.descuento = descuento;
	}
	
	public PromocionPorcentual( String nombre, int atraccion1_id, int atraccion2_id, double tiempo,
			double descuento, double costo, int tipo_id) {
		super(tipo_id, nombre, atraccion1_id, atraccion2_id, tiempo, costo, tipo_id);
		this.descuento = descuento;
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
	
	/*public ArrayList<Atraccion> getAtracciones() throws SQLException {
		String sql = "SELECT ID FROM PROMOCION WHERE NOMBRE = ?";
		Connection conn = ConnectionProvider.getConnection();
		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setString(1, this.getNombre());
		ResultSet resultados = statement.executeQuery();
		resultados.next();
		int row = resultados.getInt("ID");
		
		sql = "SELECT * FROM ATRACCION_PROMOCION WHERE PROMOCION_ID = ?";
		conn = ConnectionProvider.getConnection();
		statement = conn.prepareStatement(sql);
		statement.setInt(1, row);
		resultados = statement.executeQuery();

		ArrayList<Integer> ids = new ArrayList<Integer>();
		while (resultados.next()) {
			ids.add(resultados.getInt("ID"));
		}
		
		for (int id : ids) {
			sql = "SELECT * FROM atraccion WHERE ID = ?";
			conn = ConnectionProvider.getConnection();
			statement = conn.prepareStatement(sql);
			statement.setInt(1, id);
			resultados = statement.executeQuery();
			atracciones_promocion.add(new Atraccion(resultados.getString(2), resultados.getInt(3), resultados.getDouble(4), resultados.getDouble(5), resultados.getInt(6)));
		}
			
		resultados.close();
		return atracciones_promocion;
	}
	
	public Double calcularPromocion() {
		double total = (atracciones_promocion.get(0).getCosto() + atracciones_promocion.get(1).getCosto()) * this.descuento;
		return total;
	}
	*/



	

	


