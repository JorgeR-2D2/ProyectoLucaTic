package com.lucatinder.rest;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lucatinder.dao.IUsuarioDao;
import com.lucatinder.model.Contactos;
import com.lucatinder.model.Descartes;
import com.lucatinder.model.Usuario;
import com.lucatinder.service.ContactoService;
import com.lucatinder.service.DescartesService;
import com.lucatinder.service.MatchesService;
import com.lucatinder.service.UsuarioService;

@RestController
@CrossOrigin("*")
public class ControladorRest {
	
	private Logger log=Logger.getLogger("Controlador Rest: -------");
	private Usuario usuarioPadre;
	@Autowired
	private UsuarioService usi;
	
	@Autowired
	private ContactoService cs;
	
	@Autowired
	private DescartesService ds;
	
	@Autowired
	private MatchesService ms;
	
	@Autowired
	private IUsuarioDao usuDao;
	
	
	@PostMapping("/restLogin")//FUNCIONA
	public Usuario urlLoginEnviado(@RequestBody Usuario u) {
		try {
			log.info("Recibiendo info de usuario para login");
			log.info("NOMBRE: "+u.getUsername());
			log.info(u.getPassword());

			Usuario usuarioComprobador = usi.devolverUsuarioPorUsername(u.getUsername());
			log.info("Usuario encontrado:");
			log.info(usuarioComprobador.getUsername());
			log.info(usuarioComprobador.getPassword());
			
		if (u.getPassword().equals(usuarioComprobador.getPassword())) {
			log.info("Password coincidente");
			log.info((usi.devolverUsuarioPorUsername(u.getUsername())).getIdUsuario()+"");
			usuarioPadre=usi.devolverUsuarioPorUsername(u.getUsername());
			log.info(usuarioPadre.getUsername());
			return usuarioPadre;

		}else {
			log.info("Password no coincidente");
		
			return u;
		}
		}catch(Exception e) {
			log.info("El usuario no existe");
			return u;
		}
		
	}
	
	/**
	 * Este método recibe un usuario JSON y lo guarda en la BBDD.
	 * @author Yolanda
	 * @version 1.0
	 * @date 22/10/2019
	 */
	@PostMapping("/restAlta")//FUNCIONA
	public Usuario altaUsuario(@RequestBody Usuario u){
		try {
		
			usi.guardarUsuario(u);
			return usi.devolverUsuarioPorUsername(u.getUsername());
		}catch(Exception e){
			u.setIdUsuario(0);
			return u;
		}
	
	}
	
	/**
	 * Este método recibe un usuario JSON y lo elimina de la BBDD.
	 * @author Iván
	 * @version 1.0
	 * @date 23/10/2019
	 */
	@PostMapping("/restBaja")//FUNCIONA
	public Usuario bajaUsuario(@RequestBody Usuario u) {
		
			log.info(u.getIdUsuario()+"");
			log.info(u.getUsername());
			
			if(usi.devolverUsuarioPorUsername(u.getUsername()).getUsername().equals(u.getUsername())){
				log.info("Username coincidente");
				usi.eliminarUsuario(usi.devolverUsuarioPorUsername(u.getUsername()));
				log.info("User borrado");
				u.setIdUsuario(1);
				return u;
			}else {
				log.info("User no coincide, peticion desechada");
				u.setIdUsuario(0);
				return u;
			}
		
	}
	
	/**
	 * Este método recibe un usuario JSON y lo modifica de la BBDD.
	 * @author Iván
	 * @version 1.0
	 * @return 
	 * @date 23/10/2019
	 */
	@PostMapping("/restModificar")//FUNCIONA
	public Usuario modificarUsuario(@RequestBody Usuario u) {
			
		try {
			usi.modificarUsuario(u);
			return usi.devolverUsuarioPorUsername(u.getUsername());
		}catch(Exception e){
			u.setIdUsuario(0);
			return u;
		}
	}

	/**
	 * Este método recibe una lista de usuarios JSON y lo muestra de la BBDD.
	 * @author Iván
	 * @version 1.0
	 * @date 23/10/2019
	 */
	
	@PostMapping("/restListadoInicial")//FUNCIONA
	public List<Usuario> devuelveListadoInicialComplejo(@RequestBody Usuario u) {
		return usi.devuelveListadoInicialComplejo(usi.devolverUsuarioPorUsername(u.getUsername()).getIdUsuario());
	}

	/**
	 * Este método recibe un usuario JSON y devuelve la lista de Contactos de la BBDD.
	 * @author Iván
	 * @version 1.0
	 * @date 23/10/2019
	 */
	@PostMapping("/restDevuelveListadoContactos")//FUNCIONA.
	public List<Usuario> devuelveListadoContactos(@RequestBody Usuario u) {
		
		return cs.devuelveListaContactos(usi.devolverUsuarioPorUsername(u.getUsername()).getIdUsuario());
		
	}
	
	/**
	 * Este método recibe un usuario JSON y devuelve la lista de Descartes de la BBDD.
	 * @author Iván
	 * @version 1.0
	 * @date 23/10/2019
	 */
	@PostMapping("/restDevuelveListadoDescartes")//FUNCIONA
	public List<Usuario> devuelveListaDescartes(@RequestBody Usuario u) {
		return ds.devuelveListaDescartes(usi.devolverUsuarioPorUsername(u.getUsername()).getIdUsuario());
		
	}
	
	/**
	 * Este método recibe un usuario JSON y devuelve la lista de Matches de la BBDD.
	 * @author Iván
	 * @version 1.0
	 * @date 23/10/2019
	 */
	@PostMapping("/restDevuelveListadoMatches")//FUNCIONA
	public List<Usuario> devuelveListaMatches(@RequestBody Usuario u) {
		return ms.devuelveMatches(usi.devolverUsuarioPorUsername(u.getUsername()).getIdUsuario());
		
	}
	
	/**
	 * @author Iván
	 * @version 1.0
	 * @date 23/10/2019
	 */
	@PostMapping("/restContactar")//FUNCIONA
	public Usuario contactar(@RequestBody Usuario u){
		Contactos c = new Contactos();
		log.info("Usuario padre :"+usuarioPadre.getIdUsuario());
		log.info("Usuario padre :"+usuarioPadre.getUsername());
		c.setUsuarioContactante(usuarioPadre);
		c.setUsuarioContactado(usi.devolverUsuarioPorUsername(u.getUsername()));
		cs.contactar(c);
		return usi.devolverUsuarioPorUsername(u.getUsername());
	}
	
	/**
	 * @author Iván
	 * @version 1.0
	 * @date 23/10/2019
	 */
	@PostMapping("/restDescartar")//FUNCIONA
	public Usuario descartar(@RequestBody Usuario u){
		Descartes d = new Descartes();
		d.setUsuarioDescartante(usuarioPadre);
		d.setUsuarioDescartado(usi.devolverUsuarioPorUsername(u.getUsername()));
		ds.addDescarte(d);
		return usi.devolverUsuarioPorUsername(u.getUsername());
	
	}
	@GetMapping("/restTodos")
		public List<Usuario> dameTodos(){
			
		return usuDao.findAll();
	}
		
}