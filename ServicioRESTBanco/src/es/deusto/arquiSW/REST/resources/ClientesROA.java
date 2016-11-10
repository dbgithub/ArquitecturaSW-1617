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

import es.deusto.arquiSW.REST.DTO.ClienteDTO;

//Sets the path to base URL + /clientes
@Path("/clientes")
public class ClientesROA {
	
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public ArrayList<ClienteDTO> getClientes() {
		// TODO
		return null;
	}
	
	@GET
	@Path("/{cliente}")
	@Produces(MediaType.APPLICATION_XML)
	public ClienteDTO getCliente(@PathParam("cliente") String DNI) {
		// TODO
		return null;
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_XML)
	public void postCliente(ClienteDTO c) {
		// TODO
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_XML)
	public void putCliente(ClienteDTO c) {
		// TODO
	}
	
	@DELETE
	@Path("/{dni}")
	public void deleteCliente(@PathParam("dni") String DNI) {
		// TODO
	}
	
}
