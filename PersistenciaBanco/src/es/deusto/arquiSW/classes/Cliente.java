package es.deusto.arquiSW.classes;

import java.util.Set;

public class Cliente {
	
	private String DNI;
	private String nombre;
	private String apellidos;
	private String direccion;
	private String email;
	private int movil;
	private boolean empleado;
	private int PIN;
	
	private Set<Cuenta> lcuentas;
	
	/**
	 * Constructor vacio
	 */
	public Cliente() {
		
	}
	
	/**
	 * Constructor
	 * @param dNI
	 * @param nombre
	 * @param apellidos
	 * @param direccion
	 * @param email
	 * @param movil
	 * @param empleado
	 * @param pIN
	 */
	public Cliente(String dNI, String nombre, String apellidos, String direccion, String email, int movil,
			boolean empleado, int pIN) {
		this.DNI = dNI;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.direccion = direccion;
		this.email = email;
		this.movil = movil;
		this.empleado = empleado;
		this.PIN = pIN;
	}
	
	// METHODS & OPERATIONS:
	
	public String getDNI() {
		return DNI;
	}
	public void setDNI(String dNI) {
		DNI = dNI;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getMovil() {
		return movil;
	}
	public void setMovil(int movil) {
		this.movil = movil;
	}
	public boolean isEmpleado() {
		return empleado;
	}
	public void setEmpleado(boolean empleado) {
		this.empleado = empleado;
	}
	public int getPIN() {
		return PIN;
	}
	public void setPIN(int pIN) {
		PIN = pIN;
	}
	public Set<Cuenta> getLcuentas() {
		return lcuentas;
	}
	public void setLcuentas(Set<Cuenta> lcuentas) {
		this.lcuentas = lcuentas;
	}
}
