package sw;

import java.util.Date;

public class Tarjeta {
	
	public enum EnumProveedores {
		Visa,Mastercard,AmericanExpress; 
	}
	private enum TiposTarjeta {
		Credito,Debito; 
	}
	private int numero;
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
	private int cuenta;
	private int limiteExtraccion;
	private Date fechaCaducidad;
	private EnumProveedores proveedor;
	private TiposTarjeta tipo;
	private Date fechaExpedicion;
	
}
