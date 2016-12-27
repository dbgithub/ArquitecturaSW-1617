package es.deusto.arquiSW.REST.classes;

import java.util.Date;

public class Operacion {
	
	private int id;
	private Date fecha;
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
	 * @param cuenta
	 */
	public Operacion(int id, Date fecha, String tipo, float importe, Cuenta cuenta) {
		this.id = id;
		this.fecha = fecha;
		this.tipo = tipo;
		this.importe = importe;
		this.cuenta = cuenta;
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
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
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
