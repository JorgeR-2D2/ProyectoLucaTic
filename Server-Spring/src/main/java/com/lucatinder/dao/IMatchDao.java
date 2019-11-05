package com.lucatinder.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.lucatinder.model.Contactos;
import com.lucatinder.model.Match;

public interface IMatchDao extends JpaRepository<Match, Integer> {
	/**
	 * Esta query Personalizada nos devuelve los usuarios a los que el usuario haya hecho
	 * contacto
	 * 
	 * @author Jorge
	 * @param idUsuario
	 * @return Lista de usuarios contactados
	 */
	@Query(
			  value = "SELECT * FROM matches WHERE id_solicitante = ?1 or id_receptor = ?1", 
			  nativeQuery = true)
			public List<Match> devuelveListadoMatches(int idUsuarioSolicitante);
	/**
	 * Esta query Personalizada nos devuelve los posibles matches de un contacto previo
	 * 
	 * @author Jorge
	 * @param idUsuarioSolicitante, idUsuarioReceptor
	 * @return <Optional>Match
	 */
	@Query(
			  value = "SELECT * FROM matches WHERE id_solicitante = ?1 AND id_receptor = ?2 OR id_solicitante = ?2 AND id_receptor=?1", 
			  nativeQuery = true)
			public <Optional> Match devuelveMatchPorContacto(int idUsuarioSolicitante,int idUsuarioReceptor);
}
