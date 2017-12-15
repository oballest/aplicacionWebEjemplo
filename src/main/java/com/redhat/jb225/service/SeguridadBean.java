package com.redhat.jb225.service;

import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;
import javax.inject.Named;

import org.jboss.ejb3.annotation.SecurityDomain;

@Named
@Stateless
public class SeguridadBean {

	
	public void metodoRolUno(){
		System.out.println("Llamando metodo uno");
	}
	
	
	public void metodoRolDos(){
		System.out.println("Llamando metodo dos");
	}
	
}
