package es.deusto.arquiSW.struts2.actions;
import com.opensymphony.xwork2.ActionSupport;

import es.deusto.arquiSW.hibernate.DAO.HibernateDAO;
import es.deusto.arquiSW.hibernate.classes.Cliente;

@SuppressWarnings("serial")
public class DoLogin extends ActionSupport {
	private String DNI = null;
	private String PIN = null;
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
			}
			
//			System.out.println("¡Datos con espacios en blanco!");
//			addActionError("* Hey! Has de introducir algo en los campos DNI y PIN!");
//			return "WRONG";
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

	
}