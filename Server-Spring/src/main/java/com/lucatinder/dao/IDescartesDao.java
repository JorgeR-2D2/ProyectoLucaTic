package com.lucatinder.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.lucatinder.model.Descartes;
   /**
   * Esta interface hereda de JpaRepository, que nos ayuda con el trato con la bbdd
   * @author Yolanda
   * @version 1.0
   * @date 21/10/2019 
   */

public interface IDescartesDao extends JpaRepository<Descartes, Integer>  {
	
	/**
	 * Esta query Personalizada nos devuelve los usuarios descartados
	 * @author Yolanda
	 * @version 1.0
	 * @date 21/10/2019
	 */
	@Query(
			  value = "SELECT * FROM descartes WHERE id_usuario_descartante = ?1 ", 
			  nativeQuery = true)
			public List<Descartes> devuelveDescartes (int idUsuarioDescartante);

}