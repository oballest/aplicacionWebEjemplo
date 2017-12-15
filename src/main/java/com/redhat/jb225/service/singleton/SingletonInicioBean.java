package com.redhat.jb225.service.singleton;

import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.ejb.Startup;

/**
 * Session Bean implementation class SingletonInicioBean
 */
@Singleton
@LocalBean
@Startup
public class SingletonInicioBean {

    /**
     * Default constructor. 
     */
    public SingletonInicioBean() {
        // TODO Auto-generated constructor stub
    }
    
    @PostConstruct
    public void postConstructu(){
    	System.out.println("Construyendo primer bean");
    }

}
