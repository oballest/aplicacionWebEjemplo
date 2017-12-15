package com.redhat.jb225.service;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Schedule;
import javax.ejb.Stateless;
import javax.enterprise.inject.Produces;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.redhat.jb225.anotatios.Intercepted;
import com.redhat.jb225.entities.CategoriaTransacion;
import com.redhat.jb225.entities.Cliente;
import com.redhat.jb225.entities.Cuenta;
import com.redhat.jb225.entities.Gasto;
import com.redhat.jb225.entities.Ingreso;
import com.redhat.jb225.entities.Transaccion;

@Stateless
public class GastosServiceImp implements GastosService {

	@PersistenceContext
	private EntityManager em;
	
	
	@Override
	public List<CategoriaTransacion> consultarcategoriasTransaccion() {
		
		CriteriaBuilder builder = this.em.getCriteriaBuilder();
		CriteriaQuery<CategoriaTransacion> criteria = builder.createQuery(CategoriaTransacion.class);
		Root<CategoriaTransacion> root = criteria.from(CategoriaTransacion.class);
		TypedQuery<CategoriaTransacion> query = this.em.createQuery(criteria.select(root));
		
		List<CategoriaTransacion> results = query.getResultList();
		
		System.out.println("Numero de resultados "+results.size());
		
		return results;
	}
	
	public List<Cuenta> consultarCuentas() {
		CriteriaBuilder builder = this.em.getCriteriaBuilder();
		CriteriaQuery<Cuenta> criteria = builder.createQuery(Cuenta.class);
		Root<Cuenta> root = criteria.from(Cuenta.class);
		TypedQuery<Cuenta> query = this.em.createQuery(criteria.select(root));
		
		List<Cuenta> results = query.getResultList();
		
		System.out.println("Numero de resultados cuenta"+results.size());
		
		return results;
	}

	@Override
	@Intercepted
	public void registrarTransaccion(Transaccion transaccion) {
		System.out.println("Almacendando transaccion");
		em.persist(transaccion);
	}

	public void registrarGasto(Transaccion transaccion) {
		System.out.println("Registrando Gasto");
		
		Gasto gasto = new Gasto();
		gasto.setTransaccion(transaccion);
		
		em.persist(gasto);
		
		
	}

	public void registrarIngreso(Transaccion transaccion) {
		System.out.println("Registrando Ingreso "+transaccion.getId());
		
		Ingreso ingreso = new Ingreso();
		transaccion.setIngreso(ingreso);
		ingreso.setTransaccion(transaccion);
		//em.merge(transaccion);
		em.persist(ingreso);
		
	}

	public List<Transaccion> consultarTransaccionesFecha(Date fechaInicial,Date fechaFin) {
		
		CriteriaBuilder buider = this.em.getCriteriaBuilder();
		CriteriaQuery<Transaccion> criteria = buider.createQuery(Transaccion.class);
		Root<Transaccion> root = criteria.from(Transaccion.class);
		
		CriteriaQuery<Transaccion> query = criteria.select(root);
		
		if(null != fechaInicial){
			query = query.where(buider.greaterThan(root.<Date> get("fecha") , fechaInicial));
		}
		
		if(null != fechaFin){
			query = query.where(buider.lessThanOrEqualTo(root.<Date> get("fecha"), fechaFin));
		}
		
		
		TypedQuery<Transaccion> tQuery = this.em.createQuery(query);
		
		List<Transaccion> transacciones = tQuery.getResultList();
		
		System.out.println("Numero de registros filtrados "+transacciones.size());
		
		return transacciones;
	}
	
	public void crearCuenta(Cliente cliente){
		System.out.println("Registrando Cliente");
		em.persist(cliente);
	}
	
	//@Schedule(second="*/1", minute="*",hour="*", persistent=false)
	public void tareaRecurrente(){
		System.out.println("Ejecutando tarea recurrente");
	}

	@Produces
	@Named("reporteTransacciones")
	public List<Transaccion> consultarTransacciones() {
		CriteriaBuilder builder = this.em.getCriteriaBuilder();
		CriteriaQuery<Transaccion> criteria = builder.createQuery(Transaccion.class);
		Root<Transaccion> root = criteria.from(Transaccion.class);
		TypedQuery<Transaccion> query = this.em.createQuery(criteria.select(root));
		
		List<Transaccion> results = query.getResultList();
		
		System.out.println("Numero de transacciones "+results.size());
		return results;
		
	}

	public Cliente consultarCliente(Integer idCliente) {
		CriteriaBuilder builder = this.em.getCriteriaBuilder();
		CriteriaQuery<Cliente> criteria = builder.createQuery(Cliente.class);
		
		Root<Cliente> root = criteria.from(Cliente.class);
		
		CriteriaQuery<Cliente> query = criteria.select(root);
		
		
		query.where(builder.equal(root.<Integer>get("id"), idCliente));
		
		
		TypedQuery<Cliente> tQuery = this.em.createQuery(query);
		
		List<Cliente> clientes = tQuery.getResultList();
		
		System.out.println("Numero de clientes consultados "+clientes.size());
		
		return clientes.get(0);
	}

	

}
