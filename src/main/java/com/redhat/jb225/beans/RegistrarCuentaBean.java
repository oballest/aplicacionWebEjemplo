package com.redhat.jb225.beans;

import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;

import com.redhat.jb225.entities.Cliente;
import com.redhat.jb225.entities.Cuenta;
import com.redhat.jb225.service.GastosService;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Named
@ConversationScoped
public class RegistrarCuentaBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4446436283662173194L;
	@Named
	@Produces
	private Cliente cliente = new Cliente();
	@Named
	@Produces
	private Cuenta cuenta = new Cuenta();
	
	@Inject
	private GastosService service;
	
	@Inject
	private Conversation conversation;
	
	
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Cuenta getCuenta() {
		return cuenta;
	}
	public void setCuenta(Cuenta cuenta) {
		this.cuenta = cuenta;
	}
	
	public String crearCliente(){
		
		if(conversation.isTransient()){
			conversation.begin();
		}
		
		System.out.println("Crear Cliente");
		
		return "crearCuenta";
	}
	
	public String crearCuenta(){
		
		cuenta.setCliente(cliente);
		Set<Cuenta> cuentas = new HashSet<Cuenta>();
		cuenta.setFechaUltimoMovimiento(new Date());
		cuentas.add(cuenta);
		cliente.setCuentas(cuentas);
		
		System.out.println("Cliente "+cliente.getNombre()+" "+cliente.getIdentificacion());
		
		service.crearCuenta(cliente);
		conversation.end();
		
		return "resultadoCreacion";
		
	}
	
	
	
	
}
