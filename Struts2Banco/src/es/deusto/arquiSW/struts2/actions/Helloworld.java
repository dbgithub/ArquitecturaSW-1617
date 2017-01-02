// Struts2HelloWorld.java
package es.deusto.arquiSW.struts2.actions;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Date;

@SuppressWarnings("serial")
public class Helloworld extends ActionSupport {
	public static final String MESSAGE = "Struts 2 Hello World Tutorial!";

	public String execute() throws Exception {
		setMessage(MESSAGE);
		return SUCCESS;
	}

	private String message;

	public void setMessage(String message){
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public String getCurrentTime(){
		return new Date().toString();
	}
}