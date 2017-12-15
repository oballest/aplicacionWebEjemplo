package com.redhat.jb225.beans;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.inject.Named;


@Named
@SessionScoped
public class EventosRichBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -381197060949315822L;

	private Event<String> evento;
	
	private String valorEvento = "Evento";
	private int numeroEvento = 0;
	
	public void enviarEvento(){
		evento.fire(valorEvento+" "+ numeroEvento++);
		valorEvento = valorEvento+" "+ numeroEvento++;
		System.out.println(valorEvento);
	}

	public String getValorEvento() {
		return valorEvento;
	}

	public void setValorEvento(String valorEvento) {
		this.valorEvento = valorEvento;
	}
	
}
