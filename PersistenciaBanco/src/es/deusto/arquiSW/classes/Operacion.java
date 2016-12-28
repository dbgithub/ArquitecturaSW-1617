package es.deusto.arquiSW.classes;

public class Operacion {
	
	private int id;
	private String fecha;
	private String tipo;
	private float importe;
	
	private Cuenta cuenta;
	
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
	 */
	public Operacion(int id, String fecha, String tipo, float importe) {
		this.id = id;
		this.fecha = fecha;
		this.tipo = tipo;
		this.importe = importe;
	}
	
	// METHODS & OPERATIONS:
		
		
	public Cuenta getCuenta() {
		return cuenta;
	}
	public void setCuenta(Cuenta cuenta) {
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
