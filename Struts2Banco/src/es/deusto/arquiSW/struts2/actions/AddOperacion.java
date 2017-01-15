// Struts2HelloWorld.java
package es.deusto.arquiSW.struts2.actions;
import com.opensymphony.xwork2.ActionSupport;

import es.deusto.arquiSW.hibernate.DAO.HibernateDAO;

@SuppressWarnings("serial")
public class AddOperacion extends ActionSupport {
	private String IBAN;
	private String tipo; // parametro pasado desde el .jsp
	// Declaramos e instanciamos el DAO para la comunicación con la base de datos:
	HibernateDAO miDAO = new HibernateDAO();

	public String execute() throws Exception {
		if (getIBAN() == null || getIBAN().equals("")) {
			System.out.println("Ha habido algún error en el valor del IBAN. Null o espacio en blanco");
			return "ERROR";	
		}
		return "OK";
	}

	public String getIBAN() {
		return IBAN;
	}

	public void setIBAN(String iBAN) {
		IBAN = iBAN;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

}