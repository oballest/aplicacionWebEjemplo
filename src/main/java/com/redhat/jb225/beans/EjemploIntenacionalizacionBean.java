package com.redhat.jb225.beans;

import java.util.Locale;
import java.util.Map;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

import javax.annotation.Resource;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

import com.redhat.jb225.entities.Cliente;
import com.redhat.jb225.service.SessionService;

@Named
@RequestScoped
public class EjemploIntenacionalizacionBean {
	
	@Inject
	private SessionService sesionService;
	
	
	public String getLocale(){
		Locale locale = FacesContext.getCurrentInstance().getViewRoot().getLocale();
		return locale.getDisplayName();
	}
	
	public String generarMensaje(){
		
		System.out.println("bundle "+ FacesContext.getCurrentInstance().getApplication().getMessageBundle());
		
		FacesContext context = FacesContext.getCurrentInstance();
		PropertyResourceBundle bundle = context.getApplication().evaluateExpressionGet(context, "#{msg}", PropertyResourceBundle.class);
		
		
		FacesMessage facesMessage = new FacesMessage("Leido "+bundle.getString("message"), "Leido "+bundle.getString("message"));
		FacesContext.getCurrentInstance().addMessage(null, facesMessage);
		
		consultarMenajesBundle();
		
		return null;
	}
	
	
	public void consultarMenajesBundle(){
		ResourceBundle bundle = ResourceBundle.getBundle("com.redhat.jb225.messages.messages", Locale.ENGLISH);
		ResourceBundle bundle_es = ResourceBundle.getBundle("com.redhat.jb225.messages.messages", new Locale("es"));
		
		System.out.println("English "+bundle.getString("message"));
		System.out.println("English "+bundle_es.getString("message"));
	}
	
	public void consultarVisitas(){
		System.out.println("Numero de consulta "+sesionService.registrarVisita());
	}
	
}
