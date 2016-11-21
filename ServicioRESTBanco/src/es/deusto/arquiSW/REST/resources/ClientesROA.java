package es.deusto.arquiSW.REST.resources;

import java.net.URI;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import es.deusto.arquiSW.REST.DTO.ClienteDTO;
import es.deusto.arquiSW.REST.classes.Cliente;
import es.deusto.arquiSW.REST.dao.GestorBD;
import es.deusto.arquiSW.REST.util.DTOClassesConversor;

//Sets the path to base URL + /clientes
@Path("/clientes")
public class ClientesROA {
	
	@Context
	UriInfo uriInfo; // Variable que nos ayuda a obtener informacio sobre la URI de la peticion REST
	private GestorBD dbmanager;
	private DTOClassesConversor dcc;
	
	public ClientesROA() {
		dbmanager = new GestorBD();
		dcc = new DTOClassesConversor();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public ArrayList<ClienteDTO> getClientes() {
		establecerConexionBD();
		ArrayList<ClienteDTO> resul = new ArrayList<ClienteDTO>();
		try {
			for (Cliente c : dbmanager.obtenerClientes()) {
				resul.add(dcc.ClienteToDTOCliente(c));
			};
		} catch (SQLException e) {
			System.out.println("ERROR getting Clientes in 'ClientesROA'");
			e.printStackTrace();
		}
		return resul;
	}
	
	@GET
	@Path("/{cliente}")
	@Produces(MediaType.APPLICATION_XML)
	public ClienteDTO getCliente(@PathParam("cliente") String DNI) {
		establecerConexionBD();
		ClienteDTO resul = new ClienteDTO();
		try {
			ArrayList<Cliente> tmp = dbmanager.obtenerCliente(DNI, null, null, null, null, null);
			if (tmp.size() != 0) {
				resul = dcc.ClienteToDTOCliente(tmp.get(0));
			} else {
				return null;
			}
		} catch (SQLException e) {
			System.out.println("ERROR getting a single Cliente in 'ClientesROA'");
//			e.printStackTrace();
			return null;
		}
		return resul;
	}
	
	// NOTAS personales sobre la clase Response + URI:
		// Response es un tipo de dato que puede ser devuelto en las peticiones REST. En el objeto Response puedes añadir el
		// estado de la peticion REST, puedes enviar un mensaje informativo o incluso el propio objeto (entidad) que has añadido
		// en el lado serviro o lo que fuere.
		// Entre otras cosas puedes utilizar URI de tu path expuesta al cliente para enviarsela al cliente y que sepa como puede consultar
		// ese recurso. 
		// En los metodos GET, tambien puedes utilizar la clase Response, pero comunmente lo que se devuelve es el objeto (entidad) que realmente
		// estas pidiendo.
	
	@POST
	@Consumes(MediaType.APPLICATION_XML)
	public Response postCliente(ClienteDTO c) {
		establecerConexionBD();
		Response res;
		ArrayList<Cliente> tmp = new ArrayList<Cliente>();
		tmp.add(dcc.DTOClienteToCliente(c));
		try {
			dbmanager.insertarClientes(tmp);
			URI uri = uriInfo.getAbsolutePathBuilder().path(c.getDNI()).build(); // construyes el path donde el cliente puede consultar el objeto que acabas de introducir en la BD.
			res = Response.created(uri).entity(c).build(); // Codigo: 201 (el codigo 201 viene implicito en la llamada a 'create').
		} catch (SQLException e) {
			System.err.println("ERROR en 'PostCliente': probablemente el Cliente a insertar ya se encuentre en la base de datos");
			res = Response.status(409).entity("ERROR en 'PostCliente': probablemente el Cliente a insertar ya se encuentre en la base de datos").build();
			e.printStackTrace();
		}
		return res;
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_XML)
	public Response putCliente(ClienteDTO c) {
		establecerConexionBD();
		Response res;
		try {
			dbmanager.updateCliente(dcc.DTOClienteToCliente(c));
			URI uri = uriInfo.getAbsolutePathBuilder().path(c.getDNI()).build(); // construyes el path donde el cliente puede consultar el objeto que acabas de introducir en la BD.
			res = Response.created(uri).entity(c).build(); // Codigo: 201 (el codigo 201 viene implicito en la llamada a 'create').			
		} catch (Exception e) { // Esta exception habra que sustituirla por una SQLException
			System.err.println("ERROR en 'PutCliente': problema al hacer un UPDATE del Cliente");
			res = Response.status(409).entity("ERROR en 'PutCliente': problema al hacer un UPDATE del Cliente").build();
			e.printStackTrace();
		}
		return res;
	}
	
	@DELETE
	@Path("/{dni}")
	public Response deleteCliente(@PathParam("dni") String DNI) {
		establecerConexionBD();
		Response res;
		try {
			dbmanager.deleteCliente(DNI);
			res = Response.ok().build(); // OK status.
		} catch (Exception e) { // Esta exception habra que sustituirla por una SQLException
			System.err.println("ERROR en 'DeleteCliente': problema al hacer un DELETE del Cliente");
			res = Response.status(409).entity("ERROR en 'DeleteCliente': problema al hacer un DELETE del Cliente").build();
			e.printStackTrace();
		}
		return res;
	}
	
	public void establecerConexionBD() {
		try {
//			if (!dbmanager.conexionAbierta()) {
				dbmanager.conectar();
//			}
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
