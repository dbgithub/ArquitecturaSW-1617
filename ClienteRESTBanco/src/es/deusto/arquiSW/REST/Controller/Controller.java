package es.deusto.arquiSW.REST.Controller;

import java.net.URI;
import java.util.ArrayList;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.UniformInterfaceException;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

import es.deusto.arquiSW.REST.DTO.ClienteDTO;
import es.deusto.arquiSW.REST.DTO.CuentaDTO;
import es.deusto.arquiSW.REST.DTO.TarjetaDTO;

/**
 * This class represents the controller of the Client side.
 * This class will communicate with the REST web service and will handle the response too.
 * The response will accordingly show in the UI.
 * Mas informacion sobre request y devolucion de lista de entidades en: http://slackspace.de/articles/jersey-client-retrieve-list-of-entities/
 * Ejemplos varios de GET, POST, PUT y DELETE desde lado cliente: http://howtodoinjava.com/jersey/jersey-restful-client-examples/
 * @author aitor & daniel
 *
 */
public class Controller {
	
	ArrayList<ClienteDTO> coleccionClientes;
	ArrayList<CuentaDTO> coleccionCuentas;
	ArrayList<TarjetaDTO> coleccionTarjetas;
	final String basepath= "http://localhost:8080/ServicioRESTBanco";
	URI baseURI = UriBuilder.fromUri(basepath).build();
	ClientConfig config = new DefaultClientConfig();
	Client client = Client.create(config);
	WebResource service = client.resource(baseURI);

	public Controller() {
		coleccionClientes = new ArrayList<ClienteDTO>();
		coleccionCuentas = new ArrayList<CuentaDTO>();
		coleccionTarjetas = new ArrayList<TarjetaDTO>();
	}
	
	public void probarhola() {
		String respuesta = service.path("hello").accept(MediaType.TEXT_HTML).get(String.class);
		System.out.println("probando hello... : " + respuesta);
	}
	// ******************************
	// OBTENER recursos
	
	public void obtenerClientes() {
		ArrayList<ClienteDTO> clientes;
		clientes = service.path("clientes").accept(MediaType.APPLICATION_XML).get(new GenericType<ArrayList<ClienteDTO>>(){});
		setColeccionClientes(clientes);
		System.out.println("CLIENTES obtenidos!, size=" + clientes.size());
	}
	
	public void obtenerCuentas() {
		ArrayList<CuentaDTO> cuentas;
		cuentas = service.path("cuentas").accept(MediaType.APPLICATION_XML).get(new GenericType<ArrayList<CuentaDTO>>(){});
		setColeccionCuentas(cuentas);
		System.out.println("CUENTAS obtenidos!, size=" + cuentas.size());
	}
	
	public void obtenerTarjetas() {
		ArrayList<TarjetaDTO> tarjetas;
		tarjetas = service.path("tarjetas").accept(MediaType.APPLICATION_XML).get(new GenericType<ArrayList<TarjetaDTO>>(){});
		setColeccionTarjetas(tarjetas);
		System.out.println("TARJETAS obtenidos!, size=" + tarjetas.size());
	}
	
	/**
	 * Obtener un solo cliente mediante DNI
	 * @param DNI
	 */
	public void obtenerCliente(String DNI) {
		try {
			ArrayList<ClienteDTO> clientes = new ArrayList<ClienteDTO>();
			clientes.add(service.path("clientes").path(DNI).accept(MediaType.APPLICATION_XML).get(ClienteDTO.class));
			setColeccionClientes(clientes);
			System.out.println("CLIENTE obtenido!, size=" + clientes.size());	
		} catch(UniformInterfaceException e){ // if the returned response is an error from server side, this probably means that there was not any item to retrieve
			ClientResponse r = e.getResponse();
			if (r.getStatus() == 500) {
				System.out.println("Warning! (status: " + r.getStatus() + "), apparently it doesn't exist any record with the information provided");
			}
			setColeccionClientes(null);
		}
	}
	
	/**
	 * Obtener una sola cuenta mediante IBAN
	 * @param IBAN
	 */
	public void obtenerCuenta(String IBAN) {
		try {
			ArrayList<CuentaDTO> cuentas = new ArrayList<CuentaDTO>();
			cuentas.add(service.path("cuentas").path(IBAN).accept(MediaType.APPLICATION_XML).get(CuentaDTO.class));
			setColeccionCuentas(cuentas);
			System.out.println("CUENTA obtenido!, size=" + cuentas.size());
		} catch(UniformInterfaceException e){ // if the returned response is an error from server side, this probably means that there was not any item to retrieve
			ClientResponse r = e.getResponse();
			if (r.getStatus() == 500) {
				System.out.println("Warning! (status: " + r.getStatus() + "), apparently it doesn't exist any record with the information provided");
			}
			setColeccionCuentas(null);
		}
	}
	
	/**
	 * Obtener una sola tarjeta mediante numero
	 * @param NUM
	 */
	public void obtenerTarjeta(String NUM) {
		try {
			ArrayList<TarjetaDTO> tarjetas = new ArrayList<TarjetaDTO>();
			tarjetas.add(service.path("tarjetas").path(NUM).accept(MediaType.APPLICATION_XML).get(TarjetaDTO.class));
			setColeccionTarjetas(tarjetas);
			System.out.println("TARJETA obtenido!, size=" + tarjetas.size());
		} catch(UniformInterfaceException e){ // if the returned response is an error from server side, this probably means that there was not any item to retrieve
			ClientResponse r = e.getResponse();
			if (r.getStatus() == 500) {
				System.out.println("Warning! (status: " + r.getStatus() + "), apparently it doesn't exist any record with the information provided");
			}
			setColeccionTarjetas(null);
		}
	}
	
	// ******************************
	// CREAR recursos
	
	// TYPE is the type of content consumes by the service/method
	// ACCEPT is the type of content returned by the service/method
	// PUT is the type of operation invoked. The first param is the content returned and the second one the values received.
	
	public void crearCliente(ClienteDTO c) {
		ClientResponse res = service.path("clientes").type(MediaType.APPLICATION_XML).accept(MediaType.APPLICATION_XML).post(ClientResponse.class, c);
		if (res.getStatus() == 201) { // 201: Created
			System.out.println("Cliente creado satisfactoriamente! (status:"+res.getStatus()+") DNI:"+res.getEntity(ClienteDTO.class).getDNI());
			System.out.println("Localizacion del recurso: " + res.getLocation());
		} else { // Any other error
			System.out.println("WARNING al crear cliente en 'Controller'");
			System.out.println("status:" + res.getStatus()+" | Entity:" + res.getEntity(ClienteDTO.class));
		}
	}
	
	public void crearCuenta(CuentaDTO cu) {
		ClientResponse res = service.path("cuentas").type(MediaType.APPLICATION_XML).accept(MediaType.APPLICATION_XML).post(ClientResponse.class, cu);
		if (res.getStatus() == 201) { // 201: Created
			System.out.println("Cuenta creada satisfactoriamente! (status:"+res.getStatus()+") IBAN:"+res.getEntity(CuentaDTO.class).getIBAN());
			System.out.println("Localizacion del recurso: " + res.getLocation());
		} else { // Any other error
			System.out.println("WARNING al crear cuenta en 'Controller'");
			System.out.println("status:" + res.getStatus()+" | Entity:" + res.getEntity(CuentaDTO.class));
		}
	}
	
	public void crearTarjeta(TarjetaDTO t) {
		ClientResponse res = service.path("tarjetas").type(MediaType.APPLICATION_XML).accept(MediaType.APPLICATION_XML).post(ClientResponse.class, t);
		if (res.getStatus() == 201) { // 201: Created
			System.out.println("Tarjeta creada satisfactoriamente! (status:"+res.getStatus()+") Num:"+res.getEntity(TarjetaDTO.class).getNumero());
			System.out.println("Localizacion del recurso: " + res.getLocation());
		} else { // Any other error
			System.out.println("WARNING al crear tarjeta en 'Controller'");
			System.out.println("status:" + res.getStatus()+" | Entity:" + res.getEntity(TarjetaDTO.class));
		}
	}
	
	// ******************************
	// MODIFICAR recursos
	
	public void modificarCliente(ClienteDTO c) {
		ClientResponse res = service.path("clientes").type(MediaType.APPLICATION_XML).accept(MediaType.APPLICATION_XML).put(ClientResponse.class, c);
		if (res.getStatus() == 201) { // 201: Created
			System.out.println("Cliente modificado/actualizado satisfactoriamente! (status:"+res.getStatus()+") DNI:"+res.getEntity(ClienteDTO.class).getDNI());
			System.out.println("Localizacion del recurso: " + res.getLocation());
		} else { // Any other error
			System.out.println("WARNING al modificar/actualizar cliente en 'Controller'");
			System.out.println("status:" + res.getStatus()+" | Entity:" + res.getEntity(ClienteDTO.class));
		}
	}
	
	public void modificarCuenta(CuentaDTO cu) {
		ClientResponse res = service.path("cuentas").type(MediaType.APPLICATION_XML).accept(MediaType.APPLICATION_XML).put(ClientResponse.class, cu);
		if (res.getStatus() == 201) { // 201: Created
			System.out.println("Cuenta modificada/actualizada satisfactoriamente! (status:"+res.getStatus()+") IBAN:"+res.getEntity(CuentaDTO.class).getIBAN());
			System.out.println("Localizacion del recurso: " + res.getLocation());
		} else { // Any other error
			System.out.println("WARNING al modificar/actualizar cuenta en 'Controller'");
			System.out.println("status:" + res.getStatus()+" | Entity:" + res.getEntity(CuentaDTO.class));
		}
	}
	
	public void modificarTarjeta(TarjetaDTO t) {
		ClientResponse res = service.path("tarjetas").type(MediaType.APPLICATION_XML).accept(MediaType.APPLICATION_XML).put(ClientResponse.class, t);
		if (res.getStatus() == 201) { // 201: Created
			System.out.println("Tarjeta modificada/actualizada satisfactoriamente! (status:"+res.getStatus()+") Num:"+res.getEntity(TarjetaDTO.class).getNumero());
			System.out.println("Localizacion del recurso: " + res.getLocation());
		} else { // Any other error
			System.out.println("WARNING al modificar/actualizar tarjeta en 'Controller'");
			System.out.println("status:" + res.getStatus()+" | Entity:" + res.getEntity(TarjetaDTO.class));
		}
	}
	
	// ******************************
	// ELIMINAR recursos
	
	public void eliminarCliente(String DNI) {
		ClientResponse res = service.path("clientes").path(DNI).delete(ClientResponse.class);
		if (res.getStatus() == 200) { // 200: OK
			System.out.println("Cliente eliminado satisfactoriamente! (status:"+res.getStatus()+") DNI:"+DNI);
		} else { // Any other error
			System.out.println("WARNING al eliminar cliente en 'Controller'");
			System.out.println("status:" + res.getStatus()+" | DNI:" + DNI);
		}
	}
	
	public void eliminarCuenta(String IBAN) {
		ClientResponse res = service.path("cuentas").path(IBAN).delete(ClientResponse.class);
		if (res.getStatus() == 200) { // 200: OK
			System.out.println("Cuenta eliminada satisfactoriamente! (status:"+res.getStatus()+") IBAN:"+IBAN);
		} else { // Any other error
			System.out.println("WARNING al eliminar cuenta en 'Controller'");
			System.out.println("status:" + res.getStatus()+" | IBAN:" + IBAN);
		}
	}
	
	public void eliminarTarjeta(String Num) {
		ClientResponse res = service.path("tarjetas").path(Num).delete(ClientResponse.class);
		if (res.getStatus() == 200) { // 200: OK
			System.out.println("Tarjeta eliminada satisfactoriamente! (status:"+res.getStatus()+") Num:"+Num);
		} else { // Any other error
			System.out.println("WARNING al eliminar tarjeta en 'Controller'");
			System.out.println("status:" + res.getStatus()+" | Num:" + Num);
		}
	}

	// ******************************
	// METODOS getter & setters
	
	public ArrayList<ClienteDTO> getColeccionClientes() {
		return coleccionClientes;
	}

	public void setColeccionClientes(ArrayList<ClienteDTO> coleccionClientes) {
		this.coleccionClientes = coleccionClientes;
	}

	public ArrayList<CuentaDTO> getColeccionCuentas() {
		return coleccionCuentas;
	}

	public void setColeccionCuentas(ArrayList<CuentaDTO> coleccionCuentas) {
		this.coleccionCuentas = coleccionCuentas;
	}

	public ArrayList<TarjetaDTO> getColeccionTarjetas() {
		return coleccionTarjetas;
	}

	public void setColeccionTarjetas(ArrayList<TarjetaDTO> coleccionTarjetas) {
		this.coleccionTarjetas = coleccionTarjetas;
	}
	
//	OTROS EJEMPLOS para invocar recursos mediante REST:
		// Get JSON for application
//		System.out.println(service.path("rest").path("todo").accept(MediaType.APPLICATION_JSON).get(String.class));
		// Get XML for application
//		System.out.println(service.path("rest").path("todo").accept(MediaType.APPLICATION_XML).get(String.class));
		// Get Todo object
//		Todo todo = service.path("rest").path("todo").accept(MediaType.APPLICATION_XML).get(Todo.class);
		// Get HTML
//		System.out.println(service.path("rest").path("todo").accept(MediaType.TEXT_HTML).get(String.class));
}
