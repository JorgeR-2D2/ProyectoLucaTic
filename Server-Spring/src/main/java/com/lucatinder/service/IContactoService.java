package com.lucatinder.service;

import java.util.List;

import com.lucatinder.model.Contactos;
import com.lucatinder.model.Usuario;

public interface IContactoService {

	public List<Usuario> devuelveListaContactos(int idUsuarioContactante);
	public void contactar(Contactos c);
	public void detectaMatch(Contactos c);
}
