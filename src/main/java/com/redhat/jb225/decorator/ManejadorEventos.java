package com.redhat.jb225.decorator;

import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.inject.Singleton;

import com.redhat.jb225.anotatios.Gasto;
import com.redhat.jb225.anotatios.Ingreso;
import com.redhat.jb225.entities.Transaccion;
import com.redhat.jb225.service.GastosService;

@Singleton
public class ManejadorEventos {

	@Inject
	private GastosService gastosService;
	
	
	public void manejarGasto(@Observes @Gasto Transaccion gasto){
		System.out.println("Mamejando Envento Gasto");
		gastosService.registrarGasto(gasto);
	}
	
	public void manejarIngreso(@Observes @Ingreso Transaccion ingreso){
		System.out.println("Manejando Evento Ingreso");
		gastosService.registrarIngreso(ingreso);
	}
	
	
}
