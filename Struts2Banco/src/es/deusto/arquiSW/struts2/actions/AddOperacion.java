
package es.deusto.arquiSW.struts2.actions;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Set;

import com.opensymphony.xwork2.ActionSupport;

import es.deusto.arquiSW.hibernate.DAO.HibernateDAO;
import es.deusto.arquiSW.hibernate.classes.Operacion;

@SuppressWarnings("serial")
public class AddOperacion extends ActionSupport {
	private String IBAN;
	private String tipo; // parametro pasado desde AddOperacion .jsp
	private double importe;
	// Declaramos e instanciamos el DAO para la comunicación con la base de datos:
	HibernateDAO miDAO = new HibernateDAO();

	public String execute() throws Exception {
		if (getIBAN() != null || !getIBAN().equals("")) {
			if (0 < importe && importe <= 1000) {
				if (tipo.equals("Ingreso") || tipo.equals("Extracción")) {
					Set<Operacion> opes = new HashSet<Operacion>();
					Calendar mydate = new GregorianCalendar();
					mydate.setTime(new Date());
					String date = mydate.get(Calendar.YEAR) + "-" + (mydate.get(Calendar.MONTH)+1) + "-" + mydate.get(Calendar.DAY_OF_MONTH);
					// Ahora checkeamos si la operacion es una extraccion o ingreso. Dependiendo de ello, el numero sera negativo o no.
					if (tipo.equals("Extracción")) {importe= -importe;}
					Operacion o = new Operacion(0,date,tipo, (float) importe);
					opes.add(o);
					miDAO.insertarOperacionesEnCuenta(opes, Integer.parseInt(IBAN));
				} else {
					System.out.println("El tipo de operacion no coinciden con ningún tipo correcto en lado serviddor, ¡no podemos admitir la operacion!");
					addActionError("* El tipo de operacion no coinciden con ningún tipo correcto en lado serviddor, ¡no podemos admitir la operacion!");
					return "ERROR";
				}
			} else {
				System.out.println("El importe no coincide con los limites superior (1000) e inferior (0), ¡no podemos admitir la operacion!");
				addActionError("* Hey!El importe no coincide con los limites superior (1000) e inferior (0), ¡no podemos admitir la operacion!");
				return "ERROR";
			}
		} else {
			System.out.println("Ha habido algún error en el valor del IBAN. Null o espacio en blanco");
			addActionError("* Hey! Ha habido algún error en el valor del IBAN. Null o espacio en blanco");
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

	public double getImporte() {
		return importe;
	}

	public void setImporte(double importe) {
		this.importe = importe;
	}

}