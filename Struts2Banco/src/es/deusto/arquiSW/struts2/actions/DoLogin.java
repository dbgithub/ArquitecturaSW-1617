package es.deusto.arquiSW.struts2.actions;
import java.util.ArrayList;

import com.opensymphony.xwork2.ActionSupport;

import es.deusto.arquiSW.hibernate.DAO.HibernateDAO;
import es.deusto.arquiSW.hibernate.classes.Cliente;
import es.deusto.arquiSW.hibernate.classes.Cuenta;

@SuppressWarnings("serial")
public class DoLogin extends ActionSupport {
	private String DNI = null;
	private String PIN = null;
	private String nombre;
	private ArrayList<Cuenta> cuentas = new ArrayList<Cuenta>();
	// Declaramos e instanciamos el DAO para la comunicación con la base de datos:
	HibernateDAO miDAO = new HibernateDAO();

	public String execute() throws Exception {
		System.out.println("Validando login (lado servidor)...");
		if (getDNI() == null || getPIN() == null) {
			System.out.println("Valores Null! ("+getDNI()+","+getPIN()+")");
			addActionError("* Hey! Has de introducir algo en los campos DNI y PIN!");
			return "WRONG";
		} else {
			// Acceso a la base de datos para recuperar dicho cliente y comprobar credenciales:
			Cliente resul = miDAO.obtenerCliente(getDNI(), Integer.parseInt(getPIN()));
			if (resul != null) {
				System.out.println("Login satisfactorio! :)");
				setCuentas(miDAO.obtenerCuentas(getDNI()));
			} else {
			System.out.println("¡Datos erroneos introducidos (DNI, PIN)!");
			addActionError("* Hey! Has introducido algún dato erroneo!");
			return "WRONG";	
			}
			setNombre(resul.getNombre());
			return "OK";
		}
	}

	public String getDNI() {
		return DNI;
	}

	public void setDNI(String dni) {
		DNI = dni;
	}

	public String getPIN() {
		return PIN;
	}

	public void setPIN(String pin) {
		PIN = pin;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<Cuenta> getCuentas() {
		return cuentas;
	}

	public void setCuentas(ArrayList<Cuenta> cuentas) {
		this.cuentas = cuentas;
	}

	
}