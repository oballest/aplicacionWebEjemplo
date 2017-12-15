package com.redhat.jb225.webservices;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.redhat.jb225.entities.Cliente;
import com.redhat.jb225.service.GastosService;

@Path("/transacciones")
public class ServicioTransacciones {

	@Inject
	GastosService service;
	
	@GET
	@Path("/cliente/{idCliente}")
	@Produces("text/json")
	public Cliente consultarCliente(@PathParam("idCliente") Integer idCliente){
		
		System.out.println("Consultando Cliente "+idCliente);
		
		Cliente cliente = service.consultarCliente(idCliente);
		cliente.setCuentas(null);
		
		
		System.out.println("Cliente "+cliente.getApellido());
		
		return cliente;
	}
	
	@PUT
	@Path("/cliente/actualizar/{idCliente}")
	@Consumes(MediaType.APPLICATION_JSON)
	public void actualizarCliente(@PathParam("idCliente") String idCliente, Cliente cliente){
		System.out.println("Actualizando Cliente "+idCliente);
		System.out.println("Con datos "+cliente.getNombre()+" "+cliente.getApellido()+ " identificacion "+cliente.getIdentificacion());
	}
	
	@POST
	@Path("/cliente/parametros/{idCliente}")
	public void actualizarParametro(@PathParam("idCliente") String idCliente, @QueryParam("param") String parametro){
		System.out.println("Parametros de invocacion "+idCliente+" "+parametro);
	}
	
}
