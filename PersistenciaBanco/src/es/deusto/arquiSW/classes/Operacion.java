package es.deusto.arquiSW.classes;

public class Operacion {
	
	private int id;
	private String fecha;
	private String tipo;
	private float importe;
	private int cuenta;
	
	/**
	 * Constructor vacio
	 */
	public Operacion() {
		
	}
	
	/**
	 * Constructor
	 * @param id
	 * @param fecha
	 * @param tipo
	 * @param importe
	 * @param cuenta
	 */
	public Operacion(int id, String fecha, String tipo, float importe, int cuenta) {
		this.id = id;
		this.fecha = fecha;
		this.tipo = tipo;
		this.importe = importe;
		this.cuenta = cuenta;
	}
	
	/**
	 * Another constructor without ID
	 * @param fecha
	 * @param tipo
	 * @param importe
	 * @param cuenta
	 */
	public Operacion(String fecha, String tipo, float importe, int cuenta) {
		this.fecha = fecha;
		this.tipo = tipo;
		this.importe = importe;
		this.cuenta = cuenta;
	}
	
	// METHODS & OPERATIONS:
		
		
	public int getCuenta() {
		return cuenta;
	}
	public void setCuenta(int cuenta) {
		this.cuenta = cuenta;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public float getImporte() {
		return importe;
	}
	public void setImporte(float importe) {
		this.importe = importe;
	}
	
	

}
