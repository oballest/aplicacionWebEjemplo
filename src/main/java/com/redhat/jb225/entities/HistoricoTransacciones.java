package com.redhat.jb225.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


/**
 * The persistent class for the historico_transacciones database table.
 * 
 */
@Entity
@Table(name="historico_transacciones",schema="registrogastos")
public class HistoricoTransacciones implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private Date fecha;

	@Column(name="id_transaccion")
	private Integer idTransaccion;

	@Column(name="nuevo_saldo")
	private BigDecimal nuevoSaldo;

	@Column(name="saldo_anterior")
	private BigDecimal saldoAnterior;

	//bi-directional many-to-one association to Cuenta
    @ManyToOne
	@JoinColumn(name="id_cuenta")
	private Cuenta cuenta;

    public HistoricoTransacciones() {
    }

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Integer getIdTransaccion() {
		return this.idTransaccion;
	}

	public void setIdTransaccion(Integer idTransaccion) {
		this.idTransaccion = idTransaccion;
	}

	public BigDecimal getNuevoSaldo() {
		return this.nuevoSaldo;
	}

	public void setNuevoSaldo(BigDecimal nuevoSaldo) {
		this.nuevoSaldo = nuevoSaldo;
	}

	public BigDecimal getSaldoAnterior() {
		return this.saldoAnterior;
	}

	public void setSaldoAnterior(BigDecimal saldoAnterior) {
		this.saldoAnterior = saldoAnterior;
	}

	public Cuenta getCuenta() {
		return this.cuenta;
	}

	public void setCuenta(Cuenta cuenta) {
		this.cuenta = cuenta;
	}
	
}