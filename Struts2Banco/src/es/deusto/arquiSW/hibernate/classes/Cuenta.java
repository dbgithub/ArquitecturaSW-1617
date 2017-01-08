package es.deusto.arquiSW.hibernate.classes;

import java.util.Set;

public class Cuenta {
	private int IBAN;
	private String SWIFT;
	private String fechaApertura;
	private boolean activa;
	private float saldoActual;
	private float interes;
	
	private Cliente cliente;
	private Set<Operacion> loperaciones;
	private Tarjeta tarjeta;
	
	
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
	 */
	public Cuenta(int iBAN, String sWIFT, String fechaApertura, boolean activa, float saldoActual, float interes) {
		this.IBAN = iBAN;
		this.SWIFT = sWIFT;
		this.fechaApertura = fechaApertura;
		this.activa = activa;
		this.saldoActual = saldoActual;
		this.interes = interes;
	}
	
	// METHODS & OPERATIONS:
	
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
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente titular) {
		this.cliente = titular;
	}
	public Set<Operacion> getLoperaciones() {
		return loperaciones;
	}
	public void setLoperaciones(Set<Operacion> loperaciones) {
		this.loperaciones = loperaciones;
	}
	public Tarjeta getTarjeta() {
		return tarjeta;
	}
	public void setTarjeta(Tarjeta tarjeta) {
		this.tarjeta = tarjeta;
	}
}
