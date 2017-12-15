package com.redhat.jb225.service;

import java.util.concurrent.TimeUnit;

import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.ejb.StatefulTimeout;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 * Session Bean implementation class SessionService
 */
@Stateful
@StatefulTimeout(unit=TimeUnit.SECONDS,value=60)
@LocalBean
@Named
@SessionScoped
public class SessionService {

	private int numeroInvocacion = 0;
	
    /**
     * Default constructor. 
     */
    public SessionService() {
        // TODO Auto-generated constructor stub
    }
    
    public int registrarVisita(){
    	numeroInvocacion++;
    	return numeroInvocacion;
    }

}
