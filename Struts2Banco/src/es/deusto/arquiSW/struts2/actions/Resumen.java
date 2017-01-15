// Struts2HelloWorld.java
package es.deusto.arquiSW.struts2.actions;
import com.opensymphony.xwork2.ActionSupport;
import es.deusto.arquiSW.hibernate.DAO.HibernateDAO;
import es.deusto.arquiSW.hibernate.classes.Cuenta;
import java.util.ArrayList;
import java.util.Map;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

@SuppressWarnings("serial")
public class Resumen extends ActionSupport implements SessionAware{
	private ArrayList<Cuenta> cuentas = new ArrayList<Cuenta>();
	// Declaramos e instanciamos el DAO para la comunicación con la base de datos:
	HibernateDAO miDAO = new HibernateDAO();
	// HTTP Session object:
	private SessionMap<String, Object> userSession;

	public String execute() throws Exception {
		String dni;
		if ((dni = (String) userSession.get("dni")) != null) {
			ArrayList<Cuenta> tmp = miDAO.obtenerCuentas(dni);	
			if (tmp != null) {setCuentas(tmp); System.out.println("Cuentas obtenidas correctamente en Resumen.java!");}
			
		} else {
			System.out.println("NULL value al obtener el DNI del userSession (HTTP Session)");
			return "ERROR";
		}
		return "OK";
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		userSession = (SessionMap<String, Object>) arg0;
	}

	public ArrayList<Cuenta> getCuentas() {
		return cuentas;
	}

	public void setCuentas(ArrayList<Cuenta> cuentas) {
		this.cuentas = cuentas;
	}

}