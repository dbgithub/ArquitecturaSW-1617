package es.deusto.arquiSW.struts2.actions;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import es.deusto.arquiSW.hibernate.DAO.HibernateDAO;
import es.deusto.arquiSW.hibernate.classes.Cuenta;

@SuppressWarnings("serial")
public class Transferencias extends ActionSupport {
	private String DNI;
	private List<Integer> todosibanes;
	private List<Integer> ibanescliente ;
	// Declaramos e instanciamos el DAO para la comunicación con la base de
	// datos:
	HibernateDAO miDAO = new HibernateDAO();

	public String execute() throws Exception {
		System.out.println("DNI obtenido: " + getDNI());
		todosibanes= new ArrayList<Integer>();
		ibanescliente = new ArrayList<Integer>();
		for (Cuenta cuenta : miDAO.obtenerCuentas()) {
			todosibanes.add(cuenta.getIBAN());
		}
		
		for (Cuenta cuenta : miDAO.obtenerCuentas(DNI)) {
			ibanescliente.add(cuenta.getIBAN());
		}
		return "OK";
	}

	public String getDNI() {
		return DNI;
	}

	public void setDNI(String dNI) {
		DNI = dNI;
	}

	public List<Integer> getTodosibanes() {
		return todosibanes;
	}

	public void setTodosibanes(List<Integer> todosibanes) {
		this.todosibanes = todosibanes;
	}

	public List<Integer> getIbanescliente() {
		return ibanescliente;
	}

	public void setIbanescliente(List<Integer> ibanescliente) {
		this.ibanescliente = ibanescliente;
	}

	
	
	
	
}
