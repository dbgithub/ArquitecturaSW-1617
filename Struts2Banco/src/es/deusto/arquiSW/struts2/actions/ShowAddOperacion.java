package es.deusto.arquiSW.struts2.actions;
import com.opensymphony.xwork2.ActionSupport;

import es.deusto.arquiSW.hibernate.DAO.HibernateDAO;

@SuppressWarnings("serial")
public class ShowAddOperacion extends ActionSupport {
	private String IBAN;
	private String tipo; // parametro pasado desde el .jsp
	private String[] tipos = {"Ingreso", "Extracción"};
	// Declaramos e instanciamos el DAO para la comunicación con la base de datos:
	HibernateDAO miDAO = new HibernateDAO();

	public String execute() throws Exception {
		if (getIBAN() == null || getIBAN().equals("")) {
			System.out.println("Ha habido algún error en el valor del IBAN. Null o espacio en blanco");
			return "ERROR";	
		}
		System.out.println("El tipo es: " + getTipo());
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

	public String[] getTipos() {
		return tipos;
	}

	public void setTipos(String[] tipos) {
		this.tipos = tipos;
	}

}