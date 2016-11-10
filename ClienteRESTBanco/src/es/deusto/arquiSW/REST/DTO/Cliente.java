package es.deusto.arquiSW.REST.DTO;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

/**
 * This DTO, in this occasion, is identical to the real domain class. That's the reason why object of this type
 * are not converted to an original class.
 * JAXB annotations are used to make the class seriazable and to be able to send it over Internet through the
 * REST architecture. 
 * @author aitor & daniel
 *
 */
@XmlRootElement
@XmlType(propOrder = { "DNI", "nombre", "apellidos", "direccion", "email", "movil", "empleado", "PIN" }) // opcional
public class Cliente {
	
	private String DNI;
	private String nombre;
	private String apellidos;
	private String direccion;
	private String email;
	private int movil;
	private boolean empleado;
	private int PIN;
	
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
	@XmlElement(name = "esEmpleado")
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
	
	
}
