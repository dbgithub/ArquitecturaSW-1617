package es.deusto.arquiSW.classes;

public class Tarjeta {
	
	private int numero;
	private int limiteExtraccion;
	private String fechaCaducidad;
	private String proveedor;
	private String tipo;
	private String fechaExpedicion;
	
	private Cuenta cuenta;
	
	/**
	 * Constructor vacio
	 */
	public Tarjeta() {
		
	}
	
	/**
	 * Constructor
	 * @param numero
	 * @param limiteExtraccion
	 * @param fechaCaducidad
	 * @param proveedor
	 * @param tipo
	 * @param fechaExpedicion
	 */
	public Tarjeta(int numero, int limiteExtraccion, String fechaCaducidad, String proveedor,
			String tipo, String fechaExpedicion) {
		this.numero = numero;
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
	public Cuenta getCuenta() {
		return cuenta;
	}
	public void setCuenta(Cuenta cuenta) {
		this.cuenta = cuenta;
	}
	public int getLimiteExtraccion() {
		return limiteExtraccion;
	}
	public void setLimiteExtraccion(int limiteExtraccion) {
		this.limiteExtraccion = limiteExtraccion;
	}
	public String getFechaCaducidad() {
		return fechaCaducidad;
	}
	public void setFechaCaducidad(String fechaCaducidad) {
		this.fechaCaducidad = fechaCaducidad;
	}
	public String getProveedor() {
		return proveedor;
	}
	public void setProveedor(String proveedor) {
		this.proveedor = proveedor;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getFechaExpedicion() {
		return fechaExpedicion;
	}
	public void setFechaExpedicion(String fechaExpedicion) {
		this.fechaExpedicion = fechaExpedicion;
	}	
}
