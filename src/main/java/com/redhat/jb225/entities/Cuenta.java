package com.redhat.jb225.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Past;


/**
 * The persistent class for the cuenta database table.
 * 
 */
@Entity
@Table(name="cuenta",schema="registrogastos")
public class Cuenta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name="fecha_ultimo_movimiento")
	@Past(message="{cuenta.ultimo.past}")
	private Date fechaUltimoMovimiento;

	@Min(0)
	@Max(10000)
	private BigDecimal saldo;

	//bi-directional many-to-one association to Cliente
    @ManyToOne
	@JoinColumn(name="id_cliente")
	private Cliente cliente;

	//bi-directional many-to-one association to HistoricoTransacciones
	@OneToMany(mappedBy="cuenta")
	private Set<HistoricoTransacciones> historicoTransacciones;

	//bi-directional many-to-one association to Transaccion
	@OneToMany(mappedBy="cuenta")
	private Set<Transaccion> transaccions;

    public Cuenta() {
    }

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getFechaUltimoMovimiento() {
		return this.fechaUltimoMovimiento;
	}

	public void setFechaUltimoMovimiento(Date fechaUltimoMovimiento) {
		this.fechaUltimoMovimiento = fechaUltimoMovimiento;
	}

	public BigDecimal getSaldo() {
		return this.saldo;
	}

	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public Set<HistoricoTransacciones> getHistoricoTransacciones() {
		return this.historicoTransacciones;
	}

	public void setHistoricoTransacciones(Set<HistoricoTransacciones> historicoTransacciones) {
		this.historicoTransacciones = historicoTransacciones;
	}
	
	public Set<Transaccion> getTransaccions() {
		return this.transaccions;
	}

	public void setTransaccions(Set<Transaccion> transaccions) {
		this.transaccions = transaccions;
	}
	
}