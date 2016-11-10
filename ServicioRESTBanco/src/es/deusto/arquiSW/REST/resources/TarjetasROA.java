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

import es.deusto.arquiSW.REST.DTO.TarjetaDTO;

//Sets the path to base URL + /tarjetas
@Path("/tarjetas")
public class TarjetasROA {
	
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public ArrayList<TarjetaDTO> getTarjetas() {
		// TODO
		return null;
	}
	
	@GET
	@Path("/{tarjeta}")
	@Produces(MediaType.APPLICATION_XML)
	public TarjetaDTO getTarjeta(@PathParam("tarjeta") String num) {
		// TODO
		return null;
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_XML)
	public void postTarjeta(TarjetaDTO t) {
		// TODO
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_XML)
	public void putTarjeta(TarjetaDTO t) {
		// TODO
	}
	
	@DELETE
	@Path("/{num}")
	public void deleteTarjeta(@PathParam("num") String num) {
		// TODO
	}

}
