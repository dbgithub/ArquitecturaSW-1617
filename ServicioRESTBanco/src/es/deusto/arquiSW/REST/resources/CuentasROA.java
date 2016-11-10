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

import es.deusto.arquiSW.REST.DTO.CuentaDTO;

//Sets the path to base URL + /cuentas
@Path("/cuentas")
public class CuentasROA {
	
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public ArrayList<CuentaDTO> getCuentas() {
		// TODO
		return null;
	}
	
	@GET
	@Path("/{cuenta}")
	@Produces(MediaType.APPLICATION_XML)
	public CuentaDTO getCuenta(@PathParam("cuenta") String IBAN) {
		// TODO
		return null;
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_XML)
	public void postCuenta(CuentaDTO cu) {
		// TODO
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_XML)
	public void putCuenta(CuentaDTO cu) {
		// TODO
	}
	
	@DELETE
	@Path("/{iban}")
	public void deleteCuenta(@PathParam("iban") String IBAN) {
		// TODO
	}

}
