package es.deusto.arquiSW.struts2.actions;
import com.opensymphony.xwork2.ActionSupport;

import es.deusto.arquiSW.hibernate.DAO.HibernateDAO;
import es.deusto.arquiSW.hibernate.classes.Operacion;

import java.util.ArrayList;

@SuppressWarnings("serial")
public class Operaciones extends ActionSupport {
	private String IBAN;
	private ArrayList<Operacion> operaciones = new ArrayList<Operacion>();
	// Declaramos e instanciamos el DAO para la comunicación con la base de datos:
	HibernateDAO miDAO = new HibernateDAO();

	public String execute() throws Exception {
		System.out.println("Obteniendo operaciones en Operaciones.java... (IBAN:" + getIBAN()+")");
		ArrayList<Operacion> opes = miDAO.obtenerOperaciones(Integer.parseInt(getIBAN()));
		if (opes != null) {
			setOperaciones(opes);
		} else {
			System.out.println("NULL value al obtener Operaciones del DAO en Operaciones.java");
			return "ERROR";
		}
		return "OK";
	}

	public ArrayList<Operacion> getOperaciones() {
		return operaciones;
	}

	public void setOperaciones(ArrayList<Operacion> operaciones) {
		this.operaciones = operaciones;
	}

	public String getIBAN() {
		return IBAN;
	}

	public void setIBAN(String iBAN) {
		IBAN = iBAN;
	}

}