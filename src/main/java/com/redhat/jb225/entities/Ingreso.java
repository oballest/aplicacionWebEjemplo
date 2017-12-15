package com.redhat.jb225.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ingreso database table.
 * 
 */
@Entity
@Table(name="ingreso",schema="registrogastos")
public class Ingreso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	//bi-directional one-to-one association to Transaccion
	@OneToOne
	@JoinColumn(name="id_tran", referencedColumnName="id")
	private Transaccion transaccion;

    public Ingreso() {
    }

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Transaccion getTransaccion() {
		return this.transaccion;
	}

	public void setTransaccion(Transaccion transaccion) {
		this.transaccion = transaccion;
	}
	
}