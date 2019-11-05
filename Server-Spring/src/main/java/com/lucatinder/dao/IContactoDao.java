package com.lucatinder.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.lucatinder.model.Contactos;
import com.lucatinder.model.Usuario;

public interface IContactoDao extends JpaRepository<Contactos, Integer> {
	/**
	 * Esta query Personalizada nos devuelve los usuarios a los que el usuario haya hecho
	 * contacto
	 * 
	 * @author Jorge
	 * @param idUsuario
	 * @return Lista de usuarios contactados
	 */
	@Query(
			  value = "SELECT * FROM contactos WHERE id_usuario_contactante = ?1", 
			  nativeQuery = true)
			public List<Contactos> devuelveListadoContactos(int idUsuarioContactante);
	/**
	 * Esta query Personalizada nos detecta si el usuario contactante ha sido 
	 * contactado por el usuario contactado previamente
	 * 
	 * @author Jorge
	 * @param idUsuario,idUsuarioContactado
	 * @return <Optional>Contactos
	 */
	@Query(
			  value = "SELECT * FROM contactos WHERE id_usuario_contactante = ?2 AND id_usuario_contactado = ?1", 
			  nativeQuery = true)
			public <Optional>Contactos detectaMatch(int idUsuarioContactante,int idUsuarioContactado);
	/**
	 * Esta query Personalizada nos detecta si el usuario contactante ha contactado 
	 * previamente con el usuario contactado
	 * 
	 * @author Jorge
	 * @param idUsuario,idUsuarioContactado
	 * @return <Optional>Contactos
	 */
	@Query(
			  value = "SELECT * FROM contactos WHERE id_usuario_contactante = ?1 AND id_usuario_contactado = ?2", 
			  nativeQuery = true)
			public <Optional>Contactos compruebaContactoPrevio(int idUsuarioContactante,int idUsuarioContactado);
}
