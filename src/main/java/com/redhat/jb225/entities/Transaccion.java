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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotNull;


/**
 * The persistent class for the transaccion database table.
 * 
 */
@Entity
@Table(name="transaccion",schema="registrogastos")
public class Transaccion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private Date fecha;

	private String observacion;

	@Column(name="tipo_tran")
	private Integer tipoTran;

	@NotNull(message="{transaccion.valorNulo}")
	private BigDecimal valor;

	//bi-directional many-to-one association to CategoriaTransacion
    @ManyToOne
	@JoinColumn(name="id_categoria")
	private CategoriaTransacion categoriatransacion;

	//bi-directional many-to-one association to Cuenta
    @ManyToOne
	@JoinColumn(name="id_cuenta")
	private Cuenta cuenta;

	//bi-directional one-to-one association to Gasto
	@OneToOne
	@JoinColumn(name="id", referencedColumnName="id_tran")
	private Gasto gasto;

	//bi-directional one-to-one association to Ingreso
	@OneToOne
	@JoinColumn(name="id", referencedColumnName="id_tran")
	private Ingreso ingreso;

    public Transaccion() {
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

	public String getObservacion() {
		return this.observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public Integer getTipoTran() {
		return this.tipoTran;
	}

	public void setTipoTran(Integer tipoTran) {
		this.tipoTran = tipoTran;
	}

	public BigDecimal getValor() {
		return this.valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public CategoriaTransacion getCategoriatransacion() {
		return this.categoriatransacion;
	}

	public void setCategoriatransacion(CategoriaTransacion categoriatransacion) {
		this.categoriatransacion = categoriatransacion;
	}
	
	public Cuenta getCuenta() {
		return this.cuenta;
	}

	public void setCuenta(Cuenta cuenta) {
		this.cuenta = cuenta;
	}
	
	public Gasto getGasto() {
		return this.gasto;
	}

	public void setGasto(Gasto gasto) {
		this.gasto = gasto;
	}
	
	public Ingreso getIngreso() {
		return this.ingreso;
	}

	public void setIngreso(Ingreso ingreso) {
		this.ingreso = ingreso;
	}
	
	@AssertTrue(message="El objeto no se valido correctamente")
	public boolean isTipoTranAcetado(){
		
		if(tipoTran != null && this.fecha.before(new Date())){
			return true;
		}
		return false;
	}
	
}