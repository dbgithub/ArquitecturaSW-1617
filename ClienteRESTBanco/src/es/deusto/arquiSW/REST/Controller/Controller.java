package es.deusto.arquiSW.REST.Controller;

import java.util.ArrayList;

import es.deusto.arquiSW.REST.DTO.Cliente;
import es.deusto.arquiSW.REST.DTO.Cuenta;
import es.deusto.arquiSW.REST.DTO.Tarjeta;

/**
 * This class represents the controller of the Client side.
 * This class will communicate with the REST web service and will handle the response too.
 * The response will accordingly show in the UI.
 * @author aitor & daniel
 *
 */
public class Controller {
	
	ArrayList<Cliente> coleccionClientes;
	ArrayList<Cuenta> coleccionCuentas;
	ArrayList<Tarjeta> coleccionTarjetas;

	public Controller() {
		coleccionClientes = new ArrayList<Cliente>();
		coleccionCuentas = new ArrayList<Cuenta>();
		coleccionTarjetas = new ArrayList<Tarjeta>();
	}
	
	// ******************************
	// OBTENER recursos
	
	public void obtenerClientes() {
		
	}
	
	public void obtenerCuentas() {
		
	}
	
	public void obtenerTarjetas() {
		
	}
	
	// ******************************
	// CREAR recursos
	
	public void crearCliente() {
		
	}
	
	public void crearCuenta() {
		
	}
	
	public void crearTarjeta() {
		
	}
	
	// ******************************
	// MODIFICAR recursos
	
	public void modificarCliente() {
		
	}
	
	public void modificarCuenta() {
		
	}
	
	public void modificarTarjeta() {
		
	}
	
	// ******************************
	// ELIMINAR recursos
	public void eliminarCiente() {
		
	}
	
	public void eliminarCuenta() {
		
	}
	
	public void eliminarTarjeta() {
		
	}

	// ******************************
	// METODOS getter & setters
	
	public ArrayList<Cliente> getColeccionClientes() {
		return coleccionClientes;
	}

	public void setColeccionClientes(ArrayList<Cliente> coleccionClientes) {
		this.coleccionClientes = coleccionClientes;
	}

	public ArrayList<Cuenta> getColeccionCuentas() {
		return coleccionCuentas;
	}

	public void setColeccionCuentas(ArrayList<Cuenta> coleccionCuentas) {
		this.coleccionCuentas = coleccionCuentas;
	}

	public ArrayList<Tarjeta> getColeccionTarjetas() {
		return coleccionTarjetas;
	}

	public void setColeccionTarjetas(ArrayList<Tarjeta> coleccionTarjetas) {
		this.coleccionTarjetas = coleccionTarjetas;
	}
	
	// CLIENT SIDE (examples...):
//	ClientConfig config = new DefaultClientConfig();
//	Client client = Client.create(config);
//	WebResource service = client.resource(getBaseURI());
//	// Get JSON for application
//	System.out.println(service.path("rest").path("todo").accept(
//			MediaType.APPLICATION_JSON).get(String.class));
//	// Get XML for application
//	System.out.println(service.path("rest").path("todo").accept(
//			MediaType.APPLICATION_XML).get(String.class));
//	// Get Todo object
//	Todo todo = service.path("rest").path("todo").accept(
//			MediaType.APPLICATION_XML).get(Todo.class);
//	System.out.println(todo.getDescription());
//	// Get HTML
//	System.out.println(service.path("rest").path("todo").accept(
//			MediaType.TEXT_HTML).get(String.class));
}
