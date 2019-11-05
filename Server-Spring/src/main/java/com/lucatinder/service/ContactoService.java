package com.lucatinder.service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucatinder.dao.IContactoDao;
import com.lucatinder.model.Contactos;
import com.lucatinder.model.Match;
import com.lucatinder.model.Usuario;

@Service
public class ContactoService implements IContactoService {

	@Autowired
	private IContactoDao contactoDao;
	
	@Autowired
	private IMatchesService matchService;
	
	private Logger log=Logger.getLogger("ContactoService: -------");
	
	/**
	 * Este método devuelve una lista de contactos en base al id de un Usuario dado
	 * @author Jorge
	 * @param idUsuarioContactante
	 */
	@Override
	public List<Usuario> devuelveListaContactos(int idUsuarioContactante) {
		
		List<Contactos> contactos=contactoDao.devuelveListadoContactos(idUsuarioContactante);
		List<Usuario> listaUsuarios=new ArrayList<>();
		log.info("Iniciando búsqueda de contactos");
		for (Contactos c:contactos) {
			listaUsuarios.add(c.getUsuarioContactado());
			log.info("Contacto encontrado");
			log.info("  -"+c.getUsuarioContactado().getNombre());
		}
		return listaUsuarios;
	}

	/**Método para subir un contacto contra la BBDD, siempre y cuando 
	 * pase los parámetros del método detectaMatch();
	 * 
	 * @author Jorge
	 * @param Contacto
	 */
	@Override
	public void contactar(Contactos c) {
		detectaMatch(c);
		
	}
	/**Método para concretar la existencia de un Contacto previo,
	 * y si es así eliminar dicho Contacto y convertirlo en un Match
	 * 
	 * @author Jorge
	 * @param Contacto
	 */
	@Override
	public void detectaMatch(Contactos c) {
		Contactos matchContacto=contactoDao.detectaMatch(c.getUsuarioContactante().getIdUsuario(), c.getUsuarioContactado().getIdUsuario());
		Contactos previoContacto=contactoDao.compruebaContactoPrevio(c.getUsuarioContactante().getIdUsuario(), c.getUsuarioContactado().getIdUsuario());
		Match previoMatch=matchService.devuelveMatch(c.getUsuarioContactante().getIdUsuario(), c.getUsuarioContactado().getIdUsuario());
		Match match=new Match();
		log.info("Detectando Posible Match");
		
		if(matchContacto!=null && previoContacto==null) {
			log.info("El usuario había sido contactado previamente por el otro usuario");
			
			if(previoMatch!=null) {
				log.info("El match ya había sido realizado");
				
			}else {
				match.setUsuarioSolicitante(matchContacto.getUsuarioContactado());
				match.setUsuarioReceptor(matchContacto.getUsuarioContactante());
				
				
				matchService.guardarMatch(match);
				log.info("Match almacenado con éxito");
				
			}
			contactoDao.delete(matchContacto);
		}
		else if(previoContacto!=null) {
			log.info("Este Contacto ya ha sido realizado previamente");
			
		}
		else {
			if(previoMatch!=null) {
				log.info("Existe un match previo, no se modifica nada");
				
			}else {
			log.info("No hay coincidencias, almacenando Contacto");
			contactoDao.save(c);
			
			}
		}
		
	}

}
