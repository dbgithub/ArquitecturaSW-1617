package sw;

import java.util.ArrayList;
import java.util.Date;
import sw.Cliente;

public class Cuenta {
	private int IBAN;
	private String SWIFT;
	private Date fechaApertura;
	private boolean activa;
	private float saldoActual;
	private float interes;
	private Cliente titular;
	private ArrayList<Tarjeta> tarjetas;
	private ArrayList<Operacion> operaciones;
	
	
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
	 * @param tarjetas
	 * @param operaciones
	 */
	public Cuenta(int iBAN, String sWIFT, Date fechaApertura, boolean activa, float saldoActual, float interes,
			Cliente titular, ArrayList<Tarjeta> tarjetas, ArrayList<Operacion> operaciones) {
		this.IBAN = iBAN;
		this.SWIFT = sWIFT;
		this.fechaApertura = fechaApertura;
		this.activa = activa;
		this.saldoActual = saldoActual;
		this.interes = interes;
		this.titular = titular;
		this.tarjetas = tarjetas;
		this.operaciones = operaciones;
	}
	
	// METHODS & OPERATIONS:
	
	public Cliente getTitular() {
		return titular;
	}
	public void setTitular(Cliente titular) {
		this.titular = titular;
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
	public Date getFechaApertura() {
		return fechaApertura;
	}
	public void setFechaApertura(Date fechaApertura) {
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
	public ArrayList<Tarjeta> getTarjetas() {
		return tarjetas;
	}
	public void setTarjetas(ArrayList<Tarjeta> tarjetas) {
		this.tarjetas = tarjetas;
	}
	public ArrayList<Operacion> getOperaciones() {
		return operaciones;
	}
	public void setOperaciones(ArrayList<Operacion> operaciones) {
		this.operaciones = operaciones;
	}

	
}
