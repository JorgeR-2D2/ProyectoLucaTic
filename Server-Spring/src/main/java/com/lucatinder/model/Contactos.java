package com.lucatinder.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 * Creamos la clase Contactos,listado de perfiles en la que el usuario1 
 * hace un link sobre el usuario 2.
 * Mtdo constructor, getters y setters, to string.
 * @author Yolanda
 * @version 1.0
 * @date 20/10/2019 
 *
 */
@Entity 

public class Contactos  {
	
	@Id
	@GeneratedValue
	private int id;
	
	@OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "idUsuarioContactante", referencedColumnName = "idUsuario")
	private Usuario usuarioContactante;
	
	@OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "idUsuarioContactado", referencedColumnName = "idUsuario")
	private Usuario usuarioContactado;

	public Contactos() {
		super();
	}

	public Contactos(int id, Usuario usuarioContactante, Usuario usuarioContactado) {
		super();
		this.id = id;
		this.usuarioContactante = usuarioContactante;
		this.usuarioContactado = usuarioContactado;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Usuario getUsuarioContactante() {
		return usuarioContactante;
	}

	public void setUsuarioContactante(Usuario usuarioContactante) {
		this.usuarioContactante = usuarioContactante;
	}

	public Usuario getUsuarioContactado() {
		return usuarioContactado;
	}

	public void setUsuarioContactado(Usuario usuarioContactado) {
		this.usuarioContactado = usuarioContactado;
	}

	@Override
	public String toString() {
		return "Contactos [id=" + id + ", usuarioContactante=" + usuarioContactante + ", usuarioContactado="
				+ usuarioContactado + "]";
	}
	
	
	

 }

	