package es.deusto.arquiSW.JAXB.classes;

import java.util.Date;

import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder = { "numero", "limiteExtraccion", "fechaCaducidad", "proveedor", "tipo", "fechaExpedicion", "cuenta" }) // opcional
public class Tarjeta {
	
	private int numero;
	private int limiteExtraccion;
	private Date fechaCaducidad;
	private EnumProveedores proveedor;
	private TiposTarjeta tipo;
	private Date fechaExpedicion;
	public enum EnumProveedores {
		Visa,Mastercard,AmericanExpress; 
	}
	public enum TiposTarjeta {
		Credito,Debito; 
	}
	private int cuenta;
	
	/**
	 * Constructor vacio
	 */
	public Tarjeta() {
		
	}
	
	/**
	 * Constructor
	 * @param numero
	 * @param cuenta
	 * @param limiteExtraccion
	 * @param fechaCaducidad
	 * @param proveedor
	 * @param tipo
	 * @param fechaExpedicion
	 */
	public Tarjeta(int numero, int cuenta, int limiteExtraccion, Date fechaCaducidad, EnumProveedores proveedor,
			TiposTarjeta tipo, Date fechaExpedicion) {
		this.numero = numero;
		this.cuenta = cuenta;
		this.limiteExtraccion = limiteExtraccion;
		this.fechaCaducidad = fechaCaducidad;
		this.proveedor = proveedor;
		this.tipo = tipo;
		this.fechaExpedicion = fechaExpedicion;
	}
	
	// METHODS & OPERATIONS:
	
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public int getCuenta() {
		return cuenta;
	}
	public void setCuenta(int cuenta) {
		this.cuenta = cuenta;
	}
	public int getLimiteExtraccion() {
		return limiteExtraccion;
	}
	public void setLimiteExtraccion(int limiteExtraccion) {
		this.limiteExtraccion = limiteExtraccion;
	}
	public Date getFechaCaducidad() {
		return fechaCaducidad;
	}
	public void setFechaCaducidad(Date fechaCaducidad) {
		this.fechaCaducidad = fechaCaducidad;
	}
	public EnumProveedores getProveedor() {
		return proveedor;
	}
	public void setProveedor(EnumProveedores proveedor) {
		this.proveedor = proveedor;
	}
	public TiposTarjeta getTipo() {
		return tipo;
	}
	public void setTipo(TiposTarjeta tipo) {
		this.tipo = tipo;
	}
	public Date getFechaExpedicion() {
		return fechaExpedicion;
	}
	public void setFechaExpedicion(Date fechaExpedicion) {
		this.fechaExpedicion = fechaExpedicion;
	}
	
}
