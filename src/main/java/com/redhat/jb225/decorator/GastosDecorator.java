package com.redhat.jb225.decorator;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.enterprise.event.Event;
import javax.enterprise.inject.Any;
import javax.inject.Inject;

import com.redhat.jb225.anotatios.Gasto;
import com.redhat.jb225.anotatios.Ingreso;
import com.redhat.jb225.entities.Transaccion;
import com.redhat.jb225.service.GastosService;

@Decorator
public abstract class GastosDecorator implements GastosService {
	
	@Inject
	@Delegate
	@Any
	private GastosService gastosService;
	
	@Inject
	@Gasto
	Event<Transaccion> gastosEvent;
	
	@Inject
	@Ingreso
	Event<Transaccion> ingresoevent;
	

	public void registrarTransaccion(Transaccion transaccion) {
		
		gastosService.registrarTransaccion(transaccion);
		
		System.out.println("Decorando la creacion de transacion con id "+transaccion.getId());
		
		if(transaccion.getTipoTran() == 0){
			System.out.println("Lanzando evento para gastos");
			gastosEvent.fire(transaccion);
		}else{
			System.out.println("Lanzando evento para ingreso");
			ingresoevent.fire(transaccion);
		}
		

	}

}
