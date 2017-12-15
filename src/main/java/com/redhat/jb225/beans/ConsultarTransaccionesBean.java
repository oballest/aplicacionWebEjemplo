package com.redhat.jb225.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Schedule;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.enterprise.inject.Produces;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import com.redhat.jb225.entities.Transaccion;
import com.redhat.jb225.service.GastosService;

@Named
@ConversationScoped
public class ConsultarTransaccionesBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6770576439464929959L;
	
	
	@Inject
	private GastosService service;
	
	@NotNull(message="Fecha Inicial no puede ser nula")
	@Past(message="La fecha inicial debe ser anterior a la actual")
	private Date fechaInicial;
	
	@NotNull(message="Fecha Final no puede ser nula")
	@Past(message="La fecha Final debe ser anterior a la actual")
	private Date fechaFinal;
	
	@Named("transConsulta")
	@Produces
	private List<Transaccion> transacciones = new ArrayList<Transaccion>();
	
	@Inject
	private Conversation conversation;
	
	public ConsultarTransaccionesBean(){
		System.out.println("Construyendo Consulta Transacciones");
	}
	
	@PostConstruct
	public void postConstruct(){
		/*if(conversation.isTransient()){
			conversation.begin();
		}*/
		
	}
	
	@PreDestroy
	public void destroy(){
		System.out.println("Terminando conversacion");
		//conversation.end();
	}
	
	
	public Date getFechaInicial() {
		return fechaInicial;
	}
	
	public void setFechaInicial(Date fechaInicial) {
		this.fechaInicial = fechaInicial;
	}
	
	public Date getFechaFinal() {
		return fechaFinal;
	}
	
	public void setFechaFinal(Date fechaFinal) {
		this.fechaFinal = fechaFinal;
	}
	
	public void consultarTransacciones(){
		transacciones = service.consultarTransaccionesFecha(fechaInicial, fechaFinal);
		
		if(null == transacciones){
			transacciones = new ArrayList<Transaccion>();
		}
		
		System.out.println("Numero de transacciones consultadas "+transacciones.size());
		
		FacesMessage fm = new FacesMessage("Se consultaron "+transacciones.size()+" transacciones", "Se consultaron "+transacciones.size()+" transacciones");
		FacesContext.getCurrentInstance().addMessage(null, fm);
	}
	

}
