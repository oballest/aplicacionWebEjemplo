package com.redhat.jb225.webservices;

import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/ServicioEjemplo")
public class ServicioEjemplo {

	@GET()
	@Produces("text/plain")
	@Path("/hola")
	public String sayHello() {
	    return "Hello World!";
	}
}
