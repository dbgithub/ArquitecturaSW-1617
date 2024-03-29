package es.deusto.arquiSW.REST.classes;

import java.util.ArrayList;

public class Cliente {
	
	private String DNI;
	private String nombre;
	private String apellidos;
	private String direccion;
	private String email;
	private int movil;
	private boolean empleado;
	private int PIN;
	private ArrayList<Cuenta> cuentas;
	
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
	 * @param cuentas
	 */
	public Cliente(String dNI, String nombre, String apellidos, String direccion, String email, int movil,
			boolean empleado, int pIN, ArrayList<Cuenta> cuentas) {
		this.DNI = dNI;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.direccion = direccion;
		this.email = email;
		this.movil = movil;
		this.empleado = empleado;
		this.PIN = pIN;
		this.setCuentas(cuentas);
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
	public ArrayList<Cuenta> getCuentas() {
		return cuentas;
	}
	public void setCuentas(ArrayList<Cuenta> cuentas) {
		this.cuentas = cuentas;
	}
	
}
