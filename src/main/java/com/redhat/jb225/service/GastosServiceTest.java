package com.redhat.jb225.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.enterprise.inject.Alternative;

import com.redhat.jb225.anotatios.Intercepted;
import com.redhat.jb225.anotatios.ServicioTest;
import com.redhat.jb225.entities.CategoriaTransacion;
import com.redhat.jb225.entities.Cliente;
import com.redhat.jb225.entities.Cuenta;
import com.redhat.jb225.entities.Gasto;
import com.redhat.jb225.entities.Ingreso;
import com.redhat.jb225.entities.Transaccion;

//@Alternative
@ServicioTest
public class GastosServiceTest implements GastosService {
	
	
	private List<CategoriaTransacion> categoriasTransaccion;
	private List<Cuenta> cuentas;
	private List<Transaccion> transacciones = new ArrayList<Transaccion>();
	private List<Gasto> gastos = new ArrayList<Gasto>();
	private List<Ingreso> ingresos = new ArrayList<Ingreso>();
	
	public GastosServiceTest(){
		categoriasTransaccion = new ArrayList<CategoriaTransacion>();
		CategoriaTransacion categoria = new CategoriaTransacion();
		categoria.setId(1);
		categoria.setNombre("Categoria Prueba");
		categoriasTransaccion.add(categoria);
		
		
		Cuenta cuenta = new Cuenta();
		cuenta.setId(1);
		cuenta.setSaldo(new BigDecimal(0));
		
		cuentas = new ArrayList<Cuenta>();
		cuentas.add(cuenta);
		
		
	}
	

	public List<CategoriaTransacion> consultarcategoriasTransaccion() {
		return categoriasTransaccion;
	}

	public List<Cuenta> consultarCuentas() {
		return cuentas;
	}

	@Intercepted
	public void registrarTransaccion(Transaccion transaccion) {
		this.transacciones.add(transaccion);

	}

	public void registrarGasto(Transaccion transaccion) {
		Gasto gasto = new Gasto();
		gasto.setTransaccion(transaccion);
		
		this.gastos.add(gasto);

	}

	public void registrarIngreso(Transaccion transaccion) {
		Ingreso ingreso = new Ingreso();
		ingreso.setTransaccion(transaccion);
		
		this.ingresos.add(ingreso);

	}


	public List<Transaccion> consultarTransaccionesFecha(Date fechaInicial,
			Date fechaFin) {
		// TODO Auto-generated method stub
		return null;
	}


	public void crearCuenta(Cliente cliente) {
		// TODO Auto-generated method stub
		
	}


	public List<Transaccion> consultarTransacciones() {
		// TODO Auto-generated method stub
		return null;
	}


	public Cliente consultarCliente(Integer idCliente) {
		// TODO Auto-generated method stub
		return null;
	}

}
