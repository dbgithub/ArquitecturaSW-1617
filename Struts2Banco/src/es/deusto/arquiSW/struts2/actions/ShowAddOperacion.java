package es.deusto.arquiSW.struts2.actions;
import com.opensymphony.xwork2.ActionSupport;
import es.deusto.arquiSW.hibernate.DAO.HibernateDAO;

@SuppressWarnings("serial")
public class ShowAddOperacion extends ActionSupport {
	private String IBAN;
	private String tipooperacion; // parametro pasado desde Operaciones.jsp
	private String[] tipos = {"Ingreso", "Extracción"};
	// Declaramos e instanciamos el DAO para la comunicación con la base de datos:
	HibernateDAO miDAO = new HibernateDAO();

	public String execute() throws Exception {
		if (getIBAN() == null || getIBAN().equals("")) {
			System.out.println("Ha habido algún error en el valor del IBAN. Null o espacio en blanco");
			return "ERROR";	
		}
		System.out.println("El tipo de operacion sobre la que ha 'clickado' es: " + getTipooperacion());
		return "OK";
	}

	public String getIBAN() {
		return IBAN;
	}

	public void setIBAN(String iBAN) {
		IBAN = iBAN;
	}

	public String[] getTipos() {
		return tipos;
	}

	public void setTipos(String[] tipos) {
		this.tipos = tipos;
	}

	public int getTipooperacion() {
		if (tipooperacion.equals(tipos[0])) {return 0;} 
		else if (tipooperacion.equals(tipos[1])) {return 1;}
		return -1;
	}

	public void setTipooperacion(String tipooperacion) {
		this.tipooperacion = tipooperacion;
	}
}