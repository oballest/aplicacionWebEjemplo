package com.redhat.jb225.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the categoriatransacion database table.
 * 
 */
@Entity
@Table(name="categoriatransacion",schema="registrogastos")
public class CategoriaTransacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private String nombre;

	/*//bi-directional many-to-one association to Transaccion
	@OneToMany(mappedBy="categoriatransacion")
	@Transient
	private Set<Transaccion> transaccions;*/

    public CategoriaTransacion() {
    }

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/*public Set<Transaccion> getTransaccions() {
		return this.transaccions;
	}

	public void setTransaccions(Set<Transaccion> transaccions) {
		this.transaccions = transaccions;
	}*/
	
}