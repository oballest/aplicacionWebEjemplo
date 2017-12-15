package com.redhat.jb225.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the gasto database table.
 * 
 */
@Entity
@Table(name="gasto",schema="registrogastos")
public class Gasto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	//bi-directional one-to-one association to Transaccion
	@OneToOne(mappedBy="gasto")
	private Transaccion transaccion;

    public Gasto() {
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