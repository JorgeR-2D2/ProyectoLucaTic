package com.lucatinder.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Clase destinada a recoger las coincidencias entre usuarios
 * 
 * Mtdo constructor, getters y setters, to string.
 * @author Jorge
 * @version 1.0
 * @date 21/10/2019 
 *
 */
@Entity
@Table(name="matches")
public class Match  {
	
	@Id
	@GeneratedValue
	private int id;
	
	@OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name="idSolicitante", referencedColumnName = "idUsuario")
	private Usuario usuarioSolicitante;
	
	@OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name="idReceptor",referencedColumnName = "idUsuario")
	private Usuario usuarioReceptor;

	public Match() {
		super();
	}

	public Match(int id, Usuario usuarioSolicitante, Usuario usuarioReceptor) {
		super();
		this.id = id;
		this.usuarioSolicitante = usuarioSolicitante;
		this.usuarioReceptor = usuarioReceptor;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public Usuario getUsuarioSolicitante() {
		return usuarioSolicitante;
	}

	public void setUsuarioSolicitante(Usuario usuarioSolicitante) {
		this.usuarioSolicitante = usuarioSolicitante;
	}

	public Usuario getUsuarioReceptor() {
		return usuarioReceptor;
	}

	public void setUsuarioReceptor(Usuario usuarioReceptor) {
		this.usuarioReceptor = usuarioReceptor;
	}

	@Override
	public String toString() {
		return "Contactos [id=" + id + ", usuarioContactante=" + usuarioSolicitante + ", usuarioContactado="
				+ usuarioReceptor + "]";
	}
	
	
	

 }

	