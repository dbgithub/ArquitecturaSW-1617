package es.deusto.arquiSW.REST.resources;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import es.deusto.arquiSW.REST.classes.Cliente;

//Sets the path to base URL + /clientes
@Path("/clientes")
public class ClientesROA {
	
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public ArrayList<Cliente> getClientes() {
		// TODO
		return null;
	}
	
	@GET
	@Path("/{cliente}")
	@Produces(MediaType.APPLICATION_XML)
	public Cliente getCliente(@PathParam("cliente") String DNI) {
		// TODO
		return null;
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_XML)
	public void postCliente(Cliente c) {
		// TODO
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_XML)
	public void putCliente(Cliente c) {
		// TODO
	}
	
	@DELETE
	@Path("/{dni}")
	public void deleteCliente(@PathParam("dni") String DNI) {
		// TODO
	}
	
}
