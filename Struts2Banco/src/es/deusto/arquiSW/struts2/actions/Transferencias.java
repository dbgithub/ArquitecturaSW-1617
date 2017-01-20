package es.deusto.arquiSW.struts2.actions;

import java.util.ArrayList;

import java.util.Iterator;
import java.util.List;
import java.util.Map;


import com.opensymphony.xwork2.ActionSupport;

import es.deusto.arquiSW.hibernate.DAO.HibernateDAO;
import es.deusto.arquiSW.hibernate.classes.Cuenta;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

@SuppressWarnings("serial")
public class Transferencias extends ActionSupport implements SessionAware {
 
	private List<Integer> todosibanes;
	private List<Integer> ibanescliente ;
	// Declaramos e instanciamos el DAO para la comunicación con la base de
	// datos:
	HibernateDAO miDAO = new HibernateDAO();
	private SessionMap<String, Object> userSession;

	public String execute() throws Exception {
		String DNI;
		if ((DNI = (String) userSession.get("dni")) != null){
			todosibanes= new ArrayList<Integer>();
			ibanescliente = new ArrayList<Integer>();
			for (Cuenta cuenta : miDAO.obtenerCuentas()) {
				todosibanes.add(cuenta.getIBAN());
			}
			
			for (Cuenta cuenta : miDAO.obtenerCuentas(DNI)) {
				ibanescliente.add(cuenta.getIBAN());
			}
			return "OK";
		}else{
			System.out.println("NULL value al obtener el DNI del userSession (HTTP Session)");
			return "ERROR";
		}
		
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

	@Override
	public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		userSession = (SessionMap<String, Object>) arg0;
		
	}
	
	

	
	
	
	
}
