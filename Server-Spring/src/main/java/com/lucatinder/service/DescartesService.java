package com.lucatinder.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucatinder.dao.IDescartesDao;
import com.lucatinder.model.Descartes;
import com.lucatinder.model.Usuario;
/**
 * Implementamos la interfaz Descartes.
 * LLamamos al  método creado en la Interfaz para que nos devuelva un listado de descartes.
 * @version 1.0
 * @date 21/10/2019
 * @autor Yolanda
 **/
@Service
public class DescartesService implements IDescartesService {

	@Autowired
	private IDescartesDao descartesDao;

	@Override
	public List<Usuario> devuelveListaDescartes(int idUsuarioDescartante) {

		List<Descartes> descartes = descartesDao.devuelveDescartes(idUsuarioDescartante);
		List<Usuario> listaUsuarios = new ArrayList<>();

		for (Descartes d : descartes) {
			listaUsuarios.add(d.getUsuarioDescartado());

		}
		return listaUsuarios;

	}

	@Override
	public void addDescarte(Descartes d) {
		descartesDao.save(d);
		
	}
}
