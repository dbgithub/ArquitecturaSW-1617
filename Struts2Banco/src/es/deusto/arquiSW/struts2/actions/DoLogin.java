package es.deusto.arquiSW.struts2.actions;

import java.util.ArrayList;
import java.util.Map;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;
import com.opensymphony.xwork2.ActionSupport;
import es.deusto.arquiSW.hibernate.DAO.HibernateDAO;
import es.deusto.arquiSW.hibernate.classes.Cliente;
import es.deusto.arquiSW.hibernate.classes.Cuenta;

/**
 * Clase java de la Action 'DoLogin' que se invoca al enviar los datos de logeo.
 * Esta clase implementa la interfaz SessionAware para hacer uso del objeto HTTP Session del navegador.
 * @author aitor
 *
 */
@SuppressWarnings("serial")
public class DoLogin extends ActionSupport implements SessionAware {
	private String DNI = null;
	private String PIN = null;
	private String nombre;
	private String email;
	private int movil;
	private ArrayList<Cuenta> cuentas = new ArrayList<Cuenta>();
	// Declaramos e instanciamos el DAO para la comunicaci�n con la base de datos:
	HibernateDAO miDAO = new HibernateDAO();
	// HTTP Session object:
	private SessionMap<String, Object> userSession;

	public String execute() throws Exception {
		System.out.println("Validando login (lado servidor)...");
		if (getDNI() == null || getPIN() == null) {
			System.out.println("Valores Null! ("+getDNI()+","+getPIN()+")");
			
			addActionError(getText("err.server.dnipin"));
			return "WRONG";
		} else {
			// Acceso a la base de datos para recuperar dicho cliente y comprobar credenciales:
			Cliente resul = miDAO.obtenerCliente(getDNI(), Integer.parseInt(getPIN()));
			if (resul != null) {
				System.out.println("Login satisfactorio! :)");
				setCuentas(miDAO.obtenerCuentas(getDNI()));
				setNombre(resul.getNombre());
				setEmail(resul.getEmail());
				setMovil(resul.getMovil());
				// Estamos interesados en guardar en el objeto sesion de HTTP algunos datos para que sean persistentes de pagina en pagina:
				userSession.put("nombre", resul.getNombre());
				userSession.put("dni", getDNI());
				userSession.put("email", resul.getEmail());
				userSession.put("movil", resul.getMovil());
			} else {
			System.out.println("¡Datos erroneos introducidos (DNI, PIN)!");
			addActionError(getText("err.server.datoerroneo"));
			return "WRONG";	
			}
			return "OK";
		}
	}
	
	@Override
	public void setSession(Map<String, Object> arg0) {
		userSession = (SessionMap<String, Object>) arg0;
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


	
}