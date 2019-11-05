package com.lucatinder.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 * Creamos la clase Descartes,listado de perfiles en la que el usuario1 
 * descarta a el usuario 2.
 * Mtdo constructor, getters y setters, to string.
 * @author Yolanda
 * @version 1.0
 * @date 21/10/2019 
 *
 */
@Entity 

public class Descartes {
	
	@Id
	@GeneratedValue
	private int id;
	
	@OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "idUsuarioDescartante", referencedColumnName = "idUsuario")
	private Usuario  usuarioDescartante  ;
	
	@OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "idUsuarioDescartado", referencedColumnName = "idUsuario")
	private Usuario  usuarioDescartado  ;

	
	public Descartes() {
		super();
		
	}
	

	public Descartes(int id, Usuario usuarioDescartante, Usuario usuarioDescartado) {
		super();
		this.id = id;
		this.usuarioDescartante = usuarioDescartante;
		this.usuarioDescartado = usuarioDescartado;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Usuario getUsuarioDescartante() {
		return usuarioDescartante;
	}

	public void setUsuarioDescartante(Usuario usuarioDescartante) {
		this.usuarioDescartante = usuarioDescartante;
	}

	public Usuario getUsuarioDescartado() {
		return usuarioDescartado;
	}

	public void setUsuarioDescartado(Usuario usuarioDescartado) {
		this.usuarioDescartado = usuarioDescartado;
	}

	@Override
	public String toString() {
		return "Descartes [id=" + id + ", usuarioDescartante=" + usuarioDescartante + ", usuarioDescartado="
				+ usuarioDescartado + "]";
	}

	
	
}
