package es.deusto.arquiSW.REST.resources;

import java.net.URI;
import java.sql.SQLException;
import java.text.ParseException;
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

import es.deusto.arquiSW.REST.DTO.CuentaDTO;
import es.deusto.arquiSW.REST.classes.Cuenta;
import es.deusto.arquiSW.REST.dao.GestorBD;
import es.deusto.arquiSW.REST.util.DTOClassesConversor;

//Sets the path to base URL + /cuentas
@Path("/cuentas")
public class CuentasROA {
	
	@Context
	UriInfo uriInfo; // Variable que nos ayuda a obtener informacio sobre la URI de la peticion REST
	private GestorBD dbmanager;
	private DTOClassesConversor dcc;
	
	public CuentasROA(){
		dbmanager = new GestorBD();
		dcc = new DTOClassesConversor();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public ArrayList<CuentaDTO> getCuentas() {
		establecerConexionBD();
		ArrayList<CuentaDTO> resul = new ArrayList<CuentaDTO>();
		try {
			for (Cuenta c : dbmanager.obtenerCuentas()) {
				resul.add(dcc.CuentaToDTOCuenta(c));
			};
		} catch (SQLException e) {
			System.out.println("ERROR getting Cuentas in 'CuentasROA'");
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return resul;
	}
	
	@GET
	@Path("/{cuenta}")
	@Produces(MediaType.APPLICATION_XML)
	public CuentaDTO getCuenta(@PathParam("cuenta") String IBAN) {
		establecerConexionBD();
		CuentaDTO resul = new CuentaDTO();
		try {
			ArrayList<Cuenta> tmp = dbmanager.obtenerCuenta(IBAN, null, null, null, null);
			if (tmp.size() != 0) {
				resul = dcc.CuentaToDTOCuenta(tmp.get(0));
			} else {
				return null;
			}
		} catch (SQLException e) {
			System.out.println("ERROR getting a single Cuenta in 'CuentasROA'");
//			e.printStackTrace();
			return null;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
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
	public Response postCuenta(CuentaDTO cu) {
		establecerConexionBD();
		Response res;
		ArrayList<Cuenta> tmp = new ArrayList<Cuenta>();
		tmp.add(dcc.DTOCuentaToCuenta(cu));
		try {
			dbmanager.insertarCuentas(tmp);
			URI uri = uriInfo.getAbsolutePathBuilder().path(String.valueOf(cu.getIBAN())).build(); // construyes el path donde el cliente puede consultar el objeto que acabas de introducir en la BD.
			res = Response.created(uri).entity(cu).build(); // Codigo: 201 (el codigo 201 viene implicito en la llamada a 'create').
		} catch (SQLException e) {
			System.err.println("ERROR en 'PostCuenta': probablemente el Cuenta a insertar ya se encuentre en la base de datos");
			res = Response.status(409).entity("ERROR en 'PostCuenta': probablemente el Cuenta a insertar ya se encuentre en la base de datos").build();
			e.printStackTrace();
		}
		return res;
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_XML)
	public Response putCuenta(CuentaDTO cu) {
		establecerConexionBD();
		Response res;
		try {
			dbmanager.updateCuenta(dcc.DTOCuentaToCuenta(cu));
			URI uri = uriInfo.getAbsolutePathBuilder().path(String.valueOf(cu.getIBAN())).build(); // construyes el path donde el cliente puede consultar el objeto que acabas de introducir en la BD.
			res = Response.created(uri).entity(cu).build(); // Codigo: 201 (el codigo 201 viene implicito en la llamada a 'create').			
		} catch (Exception e) { // Esta exception habra que sustituirla por una SQLException
			System.err.println("ERROR en 'PutCuenta': problema al hacer un UPDATE del Cuenta");
			res = Response.status(409).entity("ERROR en 'PutCuenta': problema al hacer un UPDATE del Cuenta").build();
			e.printStackTrace();
		}
		return res;
	}
	
	@DELETE
	@Path("/{iban}")
	public Response deleteCuenta(@PathParam("iban") String IBAN) {
		establecerConexionBD();
		Response res;
		try {
			dbmanager.deleteCuenta(IBAN);
			res = Response.ok().build(); // OK status.
		} catch (Exception e) { // Esta exception habra que sustituirla por una SQLException
			System.err.println("ERROR en 'DeleteCuenta': problema al hacer un DELETE del Cuenta");
			res = Response.status(409).entity("ERROR en 'DeleteCuenta': problema al hacer un DELETE del Cuenta").build();
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
