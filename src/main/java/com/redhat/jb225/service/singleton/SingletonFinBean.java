package com.redhat.jb225.service.singleton;

import javax.annotation.PostConstruct;
import javax.ejb.DependsOn;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.ejb.Startup;

/**
 * Session Bean implementation class SingletonFinBean
 */
@Singleton
@LocalBean
@Startup
@DependsOn(value={"SingletonInicioBean"})
public class SingletonFinBean {

    /**
     * Default constructor. 
     */
    public SingletonFinBean() {
        // TODO Auto-generated constructor stub
    }
    
    @PostConstruct
    public void postConstruct(){
    	System.out.println("Creando segun bean");
    }

}
