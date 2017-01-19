package es.deusto.arquiSW.struts2.actions;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class i18n extends ActionSupport{
	private String request_locale;
	private String jsp;

	public String execute() throws Exception {
		if (getJsp().equals("resumen")) {return "OK_resumen";}
		if (getJsp().equals("operaciones")) {return "OK_operaciones";}
		if (getJsp().equals("addoperacion")) {return "OK_addoperacion";}
		return "ERROR";
	}

	public String getRequest_locale() {
		return request_locale;
	}

	public void setRequest_locale(String request_locale) {
		this.request_locale = request_locale;
	}

	public String getJsp() {
		return jsp;
	}

	public void setJsp(String jsp) {
		this.jsp = jsp;
	}



}