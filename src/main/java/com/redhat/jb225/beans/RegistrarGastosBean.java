package com.redhat.jb225.beans;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import com.redhat.jb225.anotatios.ServicioTest;
import com.redhat.jb225.entities.CategoriaTransacion;
import com.redhat.jb225.entities.Cuenta;
import com.redhat.jb225.entities.Transaccion;
import com.redhat.jb225.service.GastosService;

@Named
@RequestScoped
public class RegistrarGastosBean {
	
	@Inject
	//@ServicioTest
	private GastosService gastosService;
	
	@Produces
	@Named
	private Transaccion transaccion = new Transaccion();
	
	
	private List<CategoriaTransacion> categoriasTransaccion = new ArrayList<CategoriaTransacion>();
	
	@Produces
	@Named
	private List<Cuenta> cuentas = new ArrayList<Cuenta>();
	
	
	private Integer idCategoriaTran;
	private Integer idCuenta;
	
	@PostConstruct
	public void postconstruct(){
		categoriasTransaccion = gastosService.consultarcategoriasTransaccion();
		cuentas = gastosService.consultarCuentas();
	}
	
	public String registrarTransaccion(){
		System.out.println("Registrando Transaccion -id Categoria "+this.idCategoriaTran);
				
		for(CategoriaTransacion categoria : categoriasTransaccion){
			if(categoria.getId() == idCategoriaTran){
				System.out.println("Categoria seleccionada "+categoria.getNombre());
				this.transaccion.setCategoriatransacion(categoria);
			}
		}
		
		for(Cuenta cuenta : cuentas){
			if(cuenta.getId() == idCuenta){
				System.out.println("Cuenta encontrada "+cuenta.getId());
				this.transaccion.setCuenta(cuenta);
			}
		}
		
		
		gastosService.registrarTransaccion(transaccion);
		
		FacesMessage fm = new FacesMessage("Transaccion registrada correctamente", "Transaccion registrada correctamente");
		FacesContext.getCurrentInstance().addMessage(null, fm);
		
		this.transaccion = new Transaccion();
		return null;
		
	}
	
	public void validateMonto(FacesContext context, UIComponent component, Object componetValue){
		
		if(componetValue != null && ((BigDecimal) componetValue).doubleValue() > 0.0 ){
			return;
		}
		
		UIInput inputComponent = (UIInput) component;
		inputComponent.setValid(false);
		context.addMessage(component.getClientId(context), new FacesMessage("El valor debe ser mayor a 0", "El valor debe ser mayor a 0"));
		
	}

	public Transaccion getTransaccion() {
		return transaccion;
	}

	public void setTransaccion(Transaccion transaccion) {
		this.transaccion = transaccion;
	}

	public List<CategoriaTransacion> getCategoriasTransaccion() {
		return categoriasTransaccion;
	}

	public void setCategoriasTransaccion(
			List<CategoriaTransacion> categoriasTransaccion) {
		this.categoriasTransaccion = categoriasTransaccion;
	}

	public Integer getIdCategoriaTran() {
		return idCategoriaTran;
	}

	public void setIdCategoriaTran(Integer idCategoriaTran) {
		this.idCategoriaTran = idCategoriaTran;
	}

	public Integer getIdCuenta() {
		return idCuenta;
	}

	public void setIdCuenta(Integer idCuenta) {
		this.idCuenta = idCuenta;
	}
	

}
