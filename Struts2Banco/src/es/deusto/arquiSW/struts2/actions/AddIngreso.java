package es.deusto.arquiSW.struts2.actions;

import com.opensymphony.xwork2.ActionSupport;

import es.deusto.arquiSW.hibernate.DAO.HibernateDAO;
import es.deusto.arquiSW.hibernate.classes.Cliente;
import es.deusto.arquiSW.hibernate.classes.Cuenta;

@SuppressWarnings("serial")
public class AddIngreso extends ActionSupport{
	
	private String cuentaorigen = null;
	private String cuentadestino = null;
	private String importe;
	// Declaramos e instanciamos el DAO para la comunicación con la base de datos:
		HibernateDAO miDAO = new HibernateDAO();
	
	public String execute() throws Exception {
		
		System.out.println("Validando ingreso (lado servidor)...");
		
		if (getCuentaorigen() == null || getCuentadestino()== null || getImporte()==null || getImporte()=="") {
			System.out.println("Valores Null! ("+getCuentaorigen()+","+getCuentadestino()+","+getImporte()+")");
			addActionError("* Hey! Has de seleccionar una cuenta de origen, de destino e introducir una cantidad!");
			return "WRONG";
		}else{
			Cuenta origen = miDAO.obtenerCuenta(Integer.parseInt(getCuentaorigen()));
			Cuenta destino = miDAO.obtenerCuenta(Integer.parseInt(getCuentadestino()));
			float importe=Float.parseFloat(getImporte());
			origen.setSaldoActual(origen.getSaldoActual()-importe);
			destino.setSaldoActual(destino.getSaldoActual()+importe);
			miDAO.actualizarSaldo(origen.getIBAN(), origen.getSaldoActual());
			miDAO.actualizarSaldo(destino.getIBAN(), destino.getSaldoActual());
			return "OK";
		}
		
	}

	public String getCuentaorigen() {
		return cuentaorigen;
	}

	public void setCuentaorigen(String cuentaorigen) {
		this.cuentaorigen = cuentaorigen;
	}

	public String getCuentadestino() {
		return cuentadestino;
	}



	public void setCuentadestino(String cuentadestino) {
		this.cuentadestino = cuentadestino;
	}

	public String getImporte() {
		return importe;
	}

	public void setImporte(String importe) {
		this.importe = importe;
	}



}
