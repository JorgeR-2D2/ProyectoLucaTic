package com.lucatinder.dao;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.lucatinder.model.Usuario;

/**
 * 
 * @author David Esta interface hereda de JpaRepository, que nos ayuda con el
 *         trato con la bbdd
 *
 */
public interface IUsuarioDao extends JpaRepository<Usuario, Integer> {

	/**
	 * Esta query Personalizada nos devuelve un usuario por su userName
	 * 
	 * @author Jorge
	 * @param userName
	 * @return Usuario único por su username
	 */
	@Query(value = "SELECT * FROM usuario WHERE username = ?1", nativeQuery = true)
	public Usuario buscaPorUserName(String userName);

	/**
	 * Esta query Personalizada nos devuelve 20 usuarios que no correspondan con la
	 * id del usuario que se requiere por parámetro
	 * 
	 * @author Jorge
	 * @param idUsuario
	 * @return Lista de usuarios con un algoritmo sencillo
	 */
	@Query(value = "SELECT * FROM usuario WHERE id_usuario <> ?1 LIMIT 20", nativeQuery = true)
	public List<Usuario> devuelveListadoInicialSencillo(int idUsuario);

	/**
	 * Esta query Personalizada nos devuelve 20 usuarios que no correspondan con la
	 * id del usuario que se requiere por parámetro
	 * 
	 * @author Jorge
	 * @param idUsuario
	 * @return Lista de usuarios con un algoritmo sencillo
	 */
	@Query(value = "SELECT P.* FROM usuario P WHERE P.id_usuario != ?1 AND P.genero != ?2 AND P.edad > ?3 AND P.edad < ?4"
			+ " AND P.id_usuario NOT IN ("
			+ " SELECT C.id_usuario_contactado "
			+ " FROM contactos C "
			+ " JOIN usuario P ON P.id_usuario = C.id_usuario_contactante "
			+ " WHERE P.id_usuario = ?1) "
			+ " AND P.id_usuario NOT IN ("
			+ " SELECT d.id_usuario_descartado "
			+ " FROM descartes D "
			+ " JOIN usuario P ON P.id_usuario = D.id_usuario_descartante "
			+ " WHERE P.id_usuario = ?1) "
			+ " AND P.id_usuario NOT IN ("
			+ " SELECT m.id_receptor "
			+ " FROM matches M "
			+ " JOIN usuario P ON P.id_usuario = M.id_solicitante"
			+ " WHERE P.id_usuario = ?1) "
			+ " AND P.id_usuario NOT IN ("
			+ " SELECT m.id_solicitante "
			+ " FROM matches M "
			+ " JOIN usuario P ON P.id_usuario = M.id_receptor"
			+ " WHERE P.id_usuario = ?1) ", nativeQuery = true)
	public List<Usuario> devuelveListadoInicialComplejo(int idUsuario, String genero, int edadMinima, int edadMaxima);

}
