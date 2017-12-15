package com.redhat.jb225.entities;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import java.util.Set;


/**
 * The persistent class for the cliente database table.
 * 
 */
@Entity
@Table(name="cliente",schema="registrogastos")
public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull(message="{client.apellido.nulo}")
	private String apellido;

	@NotNull
	@Size(min=1,max=8,message="{client.id.size}")
	private String identificacion;

	@NotNull
	@Size(min=1,max=10,message="{client.name.size}")
	private String nombre;

	//bi-directional many-to-one association to Cuenta
	@OneToMany(mappedBy="cliente",cascade=CascadeType.PERSIST)
	private Set<Cuenta> cuentas;

    public Cliente() {
    }

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getApellido() {
		return this.apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getIdentificacion() {
		return this.identificacion;
	}

	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Set<Cuenta> getCuentas() {
		return this.cuentas;
	}

	public void setCuentas(Set<Cuenta> cuentas) {
		this.cuentas = cuentas;
	}
	
}