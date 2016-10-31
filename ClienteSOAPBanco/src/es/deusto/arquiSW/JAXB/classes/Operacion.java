package es.deusto.arquiSW.JAXB.classes;

import java.util.Date;

import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder = { "id", "fecha", "tipo", "importe", "cuenta" }) // opcional
public class Operacion {
	
	private int id;
	private Date fecha;
	private EnumTipoOperacion tipo;
	private float importe;
	public enum EnumTipoOperacion {
		Ingreso,Extraccion; 
	}
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
	public Operacion(int id, Date fecha, EnumTipoOperacion tipo, float importe, int cuenta) {
		this.id = id;
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
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public EnumTipoOperacion getTipo() {
		return tipo;
	}
	public void setTipo(EnumTipoOperacion tipo) {
		this.tipo = tipo;
	}
	public float getImporte() {
		return importe;
	}
	public void setImporte(float importe) {
		this.importe = importe;
	}
	
	

}
