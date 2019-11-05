package com.lucatinder.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucatinder.dao.IUsuarioDao;
import com.lucatinder.model.Contactos;
import com.lucatinder.model.FactoriaUsuarioAutomatico;
import com.lucatinder.model.Usuario;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	private Logger log=Logger.getLogger("UsuarioDao: -------");
	
	@Autowired
	private IUsuarioDao usuDao;
	
	@Autowired
	private IContactoService ics;
	
	@Autowired
	private IDescartesService ids;
	
	@Autowired
	private IMatchesService ims;
	
	public void guardarUsuario(Usuario u) {
		usuDao.save(u);
	}
	/**
	 * Métodos para eliminar, guardarUsuarioAutomático y listado implementados.
	 * @version 1.0
	 * @date 18/10/2019 
	 * @autor Yolanda
	 **/
	public void eliminarUsuario(Usuario u) {
		usuDao.delete(u);
	}

	@Override
	public void guardarUsuariosAutomaticos(List<Usuario> listaUsuariosAuto) {
		
		for (Usuario u:listaUsuariosAuto) {
			usuDao.save(u);
		}
	}

	@Override
	public void eliminarTodos() {
		
		usuDao.deleteAll();
	}
	@Override
	public Usuario devolverUsuarioPorUsername(String userName) {
		
		return usuDao.buscaPorUserName(userName);
	}
	
	public List<Usuario> devuelveListadoInicialSencillo(int idUsuario) {
		
		return usuDao.devuelveListadoInicialSencillo(idUsuario);
	}
	@Override
	public void modificarUsuario(Usuario u) {
		usuDao.save(u);		
	}
	@Override
	public Usuario devuelveUsuarioId(int id) {
		Optional<Usuario> u=usuDao.findById(id);
		log.info("Username del usuario buscado: "+u.get().getUsername());
		return u.get();
	}
	@Override
	public List<Usuario> devuelveListadoInicialComplejo(int idUsuario) {
		log.info("Id usuario recibido: "+idUsuario);
		Usuario u=devuelveUsuarioId(idUsuario);
		
		List<Usuario> listaUsuariosCompleja=new ArrayList<>();
		log.info("Usuario construido: "+u.getUsername());
		
		while (listaUsuariosCompleja.size()<20) {
			listaUsuariosCompleja=usuDao.devuelveListadoInicialComplejo(u.getIdUsuario(), u.getGenero(), u.getEdad()-10, u.getEdad()+10);
			log.info("Longitud listado Inicial: "+listaUsuariosCompleja.size());
			this.guardarUsuariosAutomaticos(FactoriaUsuarioAutomatico.devuelveUsuariosAuto(5));
		}
		log.info("Añadidos perfiles falsos correctamente");
		
		
		for(Usuario us:listaUsuariosCompleja) {
			if(Math.random()<0.05) {
				Contactos contacto=new Contactos();
				contacto.setUsuarioContactado(u);
				contacto.setUsuarioContactante(us);
				ics.contactar(contacto);
			}else {
				
			}
		}
		log.info("Devolviendo lista Usuarios Inicial Compleja");
		return listaUsuariosCompleja;
	}


	
		
}
	
	
	

