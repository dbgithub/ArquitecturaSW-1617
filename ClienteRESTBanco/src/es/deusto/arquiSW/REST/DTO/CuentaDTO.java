package es.deusto.arquiSW.REST.DTO;

import java.util.ArrayList;
import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * This DTO, represents the data that will flow between the Client and the REST service.
 * JAXB annotations are used to make the class seriazable and to be able to send it over Internet through the
 * REST architecture. 
 * @author aitor & daniel
 *
 */
@XmlRootElement
@XmlType(propOrder = { "IBAN", "SWIFT", "fechaApertura", "activa", "saldoActual", "interes", "titular", "operaciones" }) // opcional
public class CuentaDTO {
	private int IBAN;
	private String SWIFT;
	private Date fechaApertura;
	private boolean activa;
	private float saldoActual;
	private float interes;
	private String titular;
	
	private ArrayList<OperacionDTO> operaciones;
	
	
	/**
	 * Constructor vacio
	 */
	public CuentaDTO() {
		
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
	public CuentaDTO(int iBAN, String sWIFT, Date fechaApertura, boolean activa, float saldoActual, float interes,
			String titular, ArrayList<OperacionDTO> operaciones) {
		this.IBAN = iBAN;
		this.SWIFT = sWIFT;
		this.fechaApertura = fechaApertura;
		this.activa = activa;
		this.saldoActual = saldoActual;
		this.interes = interes;
		this.titular = titular;
		
		this.operaciones = operaciones;
	}
	
	// METHODS & OPERATIONS:
	
	public String getTitular() {
		return titular;
	}
	public void setTitular(String titular) {
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
	@XmlElement(name = "estaActiva")
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
	@XmlElementWrapper(name = "operaciones")
	@XmlElement(name = "operacion") // XmlElement especifica el nombre de las entidades
	public ArrayList<OperacionDTO> getOperaciones() {
		return operaciones;
	}
	public void setOperaciones(ArrayList<OperacionDTO> operaciones) {
		this.operaciones = operaciones;
	}
	

	
}
