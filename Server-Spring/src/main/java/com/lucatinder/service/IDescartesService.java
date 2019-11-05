package com.lucatinder.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.lucatinder.dao.IDescartesDao;
import com.lucatinder.model.Contactos;
import com.lucatinder.model.Descartes;
import com.lucatinder.model.Usuario;

/**
 * Creamos la interfaz Descartes.
 * Método para que nos devuelva un listado de descartes.
 * @version 1.0
 * @date 21/10/2019
 * @autor Yolanda
 **/

public interface IDescartesService {

	public List<Usuario> devuelveListaDescartes(int idUsuarioDescartante);
	public void addDescarte(Descartes d);
	
}


