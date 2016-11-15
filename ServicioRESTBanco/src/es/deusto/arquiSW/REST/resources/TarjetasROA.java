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

import es.deusto.arquiSW.REST.DTO.TarjetaDTO;
import es.deusto.arquiSW.REST.classes.Tarjeta;
import es.deusto.arquiSW.REST.dao.GestorBD;
import es.deusto.arquiSW.REST.util.DTOClassesConversor;

//Sets the path to base URL + /tarjetas
@Path("/tarjetas")
public class TarjetasROA {
	
	@Context
	UriInfo uriInfo; // Variable que nos ayuda a obtener informacio sobre la URI de la peticion REST
	private GestorBD dbmanager = new GestorBD();
	private DTOClassesConversor dcc = new DTOClassesConversor();

	@GET
	@Produces(MediaType.APPLICATION_XML)
	public ArrayList<TarjetaDTO> getTarjetas() {
		establecerConexionBD();
		ArrayList<TarjetaDTO> resul = new ArrayList<TarjetaDTO>();
		try {
			for (Tarjeta c : dbmanager.obtenerTarjetas()) {
				resul.add(dcc.TarjetaToDTOTarjeta(c));
			};
		} catch (SQLException e) {
			System.out.println("ERROR getting Tarjetas in 'TarjetasROA'");
			e.printStackTrace();
		}
		return resul;
	}
	
	@GET
	@Path("/{tarjeta}")
	@Produces(MediaType.APPLICATION_XML)
	public TarjetaDTO getTarjeta(@PathParam("tarjeta") String num) {
		establecerConexionBD();
		TarjetaDTO resul = new TarjetaDTO();
		try {
			resul = dcc.TarjetaToDTOTarjeta(dbmanager.obtenerTarjeta(num, null, null, null).get(0));
		} catch (SQLException e) {
			System.out.println("ERROR getting a single Tarjeta in 'TarjetasROA'");
			e.printStackTrace();
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
	public Response postTarjeta(TarjetaDTO t) {
		establecerConexionBD();
		Response res;
		ArrayList<Tarjeta> tmp = new ArrayList<Tarjeta>();
		tmp.add(dcc.DTOTarjetaToTarjeta(t));
		try {
			dbmanager.insertarTarjetas(tmp);
			URI uri = uriInfo.getAbsolutePathBuilder().path(String.valueOf(t.getNumero())).build(); // construyes el path donde el cliente puede consultar el objeto que acabas de introducir en la BD.
			res = Response.created(uri).entity(t).build(); // Codigo: 201 (el codigo 201 viene implicito en la llamada a 'create').
		} catch (SQLException e) {
			System.err.println("ERROR en 'PostTarjeta': probablemente el Tarjeta a insertar ya se encuentre en la base de datos");
			res = Response.status(409).entity("ERROR en 'PostTarjeta': probablemente el Tarjeta a insertar ya se encuentre en la base de datos").build();
			e.printStackTrace();
		}
		return res;
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_XML)
	public Response putTarjeta(TarjetaDTO t) {
		establecerConexionBD();
		Response res;
		try {
			dbmanager.updateTarjeta(dcc.DTOTarjetaToTarjeta(t));
			URI uri = uriInfo.getAbsolutePathBuilder().path(String.valueOf(t.getNumero())).build(); // construyes el path donde el cliente puede consultar el objeto que acabas de introducir en la BD.
			res = Response.created(uri).entity(t).build(); // Codigo: 201 (el codigo 201 viene implicito en la llamada a 'create').			
		} catch (Exception e) { // Esta exception habra que sustituirla por una SQLException
			System.err.println("ERROR en 'PutTarjeta': problema al hacer un UPDATE del Tarjeta");
			res = Response.status(409).entity("ERROR en 'PutTarjeta': problema al hacer un UPDATE del Tarjeta").build();
			e.printStackTrace();
		}
		return res;
	}
	
	@DELETE
	@Path("/{num}")
	public Response deleteTarjeta(@PathParam("num") String num) {
		establecerConexionBD();
		Response res;
		try {
			dbmanager.deleteTarjeta(num);
			res = Response.ok().build(); // OK status.
		} catch (Exception e) { // Esta exception habra que sustituirla por una SQLException
			System.err.println("ERROR en 'DeleteTarjeta': problema al hacer un DELETE del Tarjeta");
			res = Response.status(409).entity("ERROR en 'DeleteTarjeta': problema al hacer un DELETE del Tarjeta").build();
			e.printStackTrace();
		}
		return res;
	}
	
	public void establecerConexionBD() {
		try {
			if (!dbmanager.conexionAbierta()) {
				dbmanager.conectar();
			}
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
