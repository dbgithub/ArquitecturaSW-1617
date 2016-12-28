package es.deusto.arquiSW.classes;

import java.util.List;

public class Cuenta {
	private int IBAN;
	private String SWIFT;
	private String fechaApertura;
	private boolean activa;
	private float saldoActual;
	private float interes;
	private String cliente;
	
	private List<Operacion> operaciones;
	
	
	/**
	 * Constructor vacio
	 */
	public Cuenta() {
		
	}
	/**
	 * Constructor
	 * @param IBAN
	 * @param SWIFT
	 * @param fechaApertura
	 * @param activa
	 * @param saldoActual
	 * @param interes
	 * @param titular
	 * @param tarjeta
	 * @param operaciones
	 */
	public Cuenta(int iBAN, String sWIFT, String fechaApertura, boolean activa, float saldoActual, float interes,
			String titular, List<Operacion> operaciones) {
		this.IBAN = iBAN;
		this.SWIFT = sWIFT;
		this.fechaApertura = fechaApertura;
		this.activa = activa;
		this.saldoActual = saldoActual;
		this.interes = interes;
		this.cliente = titular;
		
		this.operaciones = operaciones;
	}
	
	/**
	 * Otro constructor sin la lista de operaciones
	 * @param iBAN
	 * @param sWIFT
	 * @param fechaApertura
	 * @param activa
	 * @param saldoActual
	 * @param interes
	 * @param titular
	 */
	public Cuenta(int iBAN, String sWIFT, String fechaApertura, boolean activa, float saldoActual, float interes,
			String titular) {
		this.IBAN = iBAN;
		this.SWIFT = sWIFT;
		this.fechaApertura = fechaApertura;
		this.activa = activa;
		this.saldoActual = saldoActual;
		this.interes = interes;
		this.cliente = titular;
	}
	
	// METHODS & OPERATIONS:
	
	public String getCliente() {
		return cliente;
	}
	public void setCliente(String titular) {
		this.cliente = titular;
	}
	public int getIBAN() {
		return IBAN;
	}
	public void setIBAN(int iBAN) {
		IBAN = iBAN;
	}
	public String getSWIFT() {
		return SWIFT;
	}
	public void setSWIFT(String sWIFT) {
		SWIFT = sWIFT;
	}
	public String getFechaApertura() {
		return fechaApertura;
	}
	public void setFechaApertura(String fechaApertura) {
		this.fechaApertura = fechaApertura;
	}
	public boolean isActiva() {
		return activa;
	}
	public void setActiva(boolean activa) {
		this.activa = activa;
	}
	public float getSaldoActual() {
		return saldoActual;
	}
	public void setSaldoActual(float saldoActual) {
		this.saldoActual = saldoActual;
	}
	public float getInteres() {
		return interes;
	}
	public void setInteres(float interes) {
		this.interes = interes;
	}
	public List<Operacion> getOperaciones() {
		return operaciones;
	}
	public void setOperaciones(List<Operacion> operaciones) {
		this.operaciones = operaciones;
	}
	

	
}
