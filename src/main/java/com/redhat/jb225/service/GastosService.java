package com.redhat.jb225.service;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import com.redhat.jb225.entities.CategoriaTransacion;
import com.redhat.jb225.entities.Cliente;
import com.redhat.jb225.entities.Cuenta;
import com.redhat.jb225.entities.Transaccion;

@Local
public interface GastosService {

	public List<CategoriaTransacion> consultarcategoriasTransaccion();
	
	public List<Cuenta> consultarCuentas();
	
	public void registrarTransaccion(Transaccion transaccion);
	
	public void registrarGasto(Transaccion transaccion);
	
	public void registrarIngreso(Transaccion transaccion);
	
	public List<Transaccion> consultarTransaccionesFecha(Date fechaInicial,Date fechaFin);
	
	public void crearCuenta(Cliente cliente);
	
	public List<Transaccion> consultarTransacciones();
	
	public Cliente consultarCliente(Integer idCliente);
	
	
	
}
