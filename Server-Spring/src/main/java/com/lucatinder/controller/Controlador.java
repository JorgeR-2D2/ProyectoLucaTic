package com.lucatinder.controller;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.lucatinder.model.Contactos;
import com.lucatinder.model.Descartes;
import com.lucatinder.model.Usuario;
import com.lucatinder.service.IContactoService;
import com.lucatinder.service.IDescartesService;
import com.lucatinder.service.IMatchesService;
import com.lucatinder.service.UsuarioService;


@Controller
/**
 * En esta clase se realizaran todas las operaciones de control.
 * 
 * @author Iván
 * @version 1.0
 * @date 18/10/2019
 */
public class Controlador {

	private Usuario usuarioPadre;
	private Logger log=Logger.getLogger("Controlador: -------");
	
	@Autowired
	private IDescartesService ids;
	
	@Autowired
	private UsuarioService usi;

	@Autowired
	private IContactoService ics;
	
	@Autowired
	private IMatchesService ims;

	/**
	 *
	 * Método para entrar en login.
	 * 
	 * @version 1.0
	 * @date 18/10/2019
	 * @autor Ivan
	 *
	 */

	@GetMapping("/")
	public String urlLogin(Model model) {
		model.addAttribute("usuario", new Usuario());
		model.addAttribute("status", "Donde ligan los que no ligan");
		return "login";
	}

	/**
	 * Metodo para comprobar usuario y contraseña.
	 * 
	 * @version 1.0
	 * @date 18/10/2019
	 * @autor Ivan & Jorge
	 */
	@PostMapping("/")
	public String urlLoginEnviado(Usuario u, Model model) {
		try {
			log.info("Recibiendo info de usuario para login");
			log.info(u.getUsername());
			log.info(u.getPassword());

			Usuario usuarioComprobador = usi.devolverUsuarioPorUsername(u.getUsername());
			log.info("Usuario encontrado:");
			log.info(usuarioComprobador.getUsername());
			log.info(usuarioComprobador.getPassword());
			
		if (u.getPassword().equals(usuarioComprobador.getPassword())) {
			log.info("Password coincidente");
			log.info((usi.devolverUsuarioPorUsername(u.getUsername())).getIdUsuario()+"Lo que queremos comprobar ahora debe ser 25");
			usuarioPadre=usi.devolverUsuarioPorUsername(u.getUsername());
			
			model.addAttribute("usuario", usuarioPadre);
			model.addAttribute("status","Nos alegra volver a verte "+usuarioPadre.getNombre()+", estas personas esperan conocerte");
			model.addAttribute("usuarioVacio", new Usuario());
			model.addAttribute("listaInicial", usi.devuelveListadoInicialComplejo(usuarioPadre.getIdUsuario()));
			return "index";
		}else {
			log.info("Password no coincidente");
			model.addAttribute("usuario", new Usuario());
			model.addAttribute("status", "El usuario o la contraseña son incorrectos");
			return "login";
		}
		
		}catch(Exception e) {
			log.info("El usuario no existe");
			model.addAttribute("usuario", new Usuario());
			model.addAttribute("status", "El usuario o la contraseña son incorrectos");
			return "login";
		}
	}

	/**
	 * Los siguientes 2 métodos sirven para en caso de no estar registrado te puedas
	 * registrar (guardar usuario).
	 * 
	 * @version 1.0
	 * @date 18/10/2019
	 * @autor Iván
	 */
	@GetMapping("/alta")
	public String urlAlta(Model model) {
		model.addAttribute("usuario", new Usuario());
		return "formularioalta";
	}
	@GetMapping("/index")
	public String urlIndex(Model model) {
		model.addAttribute("usuario", usuarioPadre);
		model.addAttribute("usuarioVacio", new Usuario());
		model.addAttribute("listaInicial", usi.devuelveListadoInicialComplejo(usuarioPadre.getIdUsuario()));
		model.addAttribute("status",usuarioPadre.getNombre()+",deprisa, estas personas esperan conocerte");
		return "index";
	}

	@PostMapping("/alta")
	public String urlAltaRecibido(Model model, Usuario u) {
		usi.guardarUsuario(u);
		log.info((usi.devolverUsuarioPorUsername(u.getUsername())).getIdUsuario()+"");
		usuarioPadre=usi.devolverUsuarioPorUsername(u.getUsername());
		model.addAttribute("usuario", usuarioPadre);
		model.addAttribute("usuarioVacio", new Usuario());
		model.addAttribute("listaInicial", usi.devuelveListadoInicialComplejo(usuarioPadre.getIdUsuario()));
		model.addAttribute("status","Bienvenido "+usuarioPadre.getNombre()+", estas personas esperan conocerte");
		return "index";
	}

	

	/**
	 * Método creado para mostrar los contactos a los que se le ha dado like
	 * 
	 * @version 1.0
	 * @param model
	 * @autor David
	 */
	@GetMapping("/listadoContactos")
	public String urlContactos(Model model) {
		model.addAttribute("usuario", usuarioPadre);
		model.addAttribute("listaContactos",ics.devuelveListaContactos(usuarioPadre.getIdUsuario()));
		model.addAttribute("status","Aquí están tus posibles futuras conquistas");
		return "listadoContactos";
	}
	
	@GetMapping("/listadoDescartes")
	public String urlDescartes(Model model) {
		model.addAttribute("usuario", usuarioPadre);
		log.info(ids.devuelveListaDescartes(usuarioPadre.getIdUsuario()).get(0).getNombre());
		model.addAttribute("listaDescartes",ids.devuelveListaDescartes(usuarioPadre.getIdUsuario()));
		model.addAttribute("status","Ten más cuidado, estas personas no podrán ser tus conquistas");
		return "listadoDescartes";
	}
	@GetMapping("/listadoMatches")
	public String urlMatches(Model model) {
		model.addAttribute("usuario", usuarioPadre);
		model.addAttribute("listaMatches",ims.devuelveMatches(usuarioPadre.getIdUsuario()));
		model.addAttribute("status","Parece que has coincidido con ell@s, lánzate");
		return "listadoMatches";
	}
	
	@PostMapping("/addContacto")
	public String urlLikeContactos (Usuario u, Model model) {
		
		log.info(u.getUsername());
		
		Contactos c=new Contactos();
		c.setUsuarioContactante(usuarioPadre);
		c.setUsuarioContactado(usi.devolverUsuarioPorUsername(u.getUsername()));
		
		ics.contactar(c);
		
		/*log.info("Recibiendo contacto");
		log.info(c.getUsuarioContactante().getUsername()+" -- "+ c.getUsuarioContactado().getUsername() );
		ics.contactar(c);*/
		model.addAttribute("contacto",new Contactos() );
		model.addAttribute("usuario", usuarioPadre);
		model.addAttribute("descarte",new Descartes());
		model.addAttribute("usuarioVacio", new Usuario());
		model.addAttribute("listaInicial", usi.devuelveListadoInicialComplejo(usuarioPadre.getIdUsuario()));
		model.addAttribute("status","Has agregado en tus contactos a "+u.getUsername());
		return "index";
	}
	@PostMapping("/addDescarte")
	public String urlDescartaContactos (Usuario u, Model model) {
		
		Descartes d=new Descartes();
		d.setUsuarioDescartante(usuarioPadre);
		d.setUsuarioDescartado(usi.devolverUsuarioPorUsername(u.getUsername()));
		
		log.info("Usuario descartado: "+d.getUsuarioDescartado().getUsername());
		ids.addDescarte(d);
		model.addAttribute("usuario", usuarioPadre);
		model.addAttribute("usuarioVacio", new Usuario());
		model.addAttribute("listaInicial", usi.devuelveListadoInicialComplejo(usuarioPadre.getIdUsuario()));
		model.addAttribute("status","Has descartado a "+u.getUsername());
		return "index";
	}

	/**
	 * Método creado para mostrar en el formulario los datos del usuario
	 * 
	 * @version 1.0
	 * @date 20/10/2019
	 * @autor Yolanda
	 */
	@GetMapping("/datos")
	public String urlMisDatos(Model model) {
		model.addAttribute("usuario", usuarioPadre);
		model.addAttribute("status","Tus datos "+usuarioPadre.getNombre()+", modifica lo que gustes");
		return "datos";
	}

	@GetMapping("/eliminar")
	public String urlEliminarUsuario(Model model) {

		usi.eliminarUsuario(usuarioPadre);
		model.addAttribute("usuario", new Usuario());
		model.addAttribute("status", "Usuario eliminado con éxito");
		return "login";

	}
	/**
	 * Método creado para modificar los datos del usuario
	 * 
	 * @version 1.0
	 * @date 21/10/2019
	 * @autor Yolanda
	 */
	@PostMapping("/modificarDatos")
	public String urlModificarUsuario(Usuario u, Model model) {
		log.info("Id: "+u.getIdUsuario());
		log.info("Username: "+u.getUsername());
		usi.guardarUsuario(u);
		
		usuarioPadre=usi.devolverUsuarioPorUsername(u.getUsername());
		model.addAttribute("usuario", usuarioPadre);
		model.addAttribute("usuarioVacio", new Usuario());
		model.addAttribute("listaInicial", usi.devuelveListadoInicialComplejo(usuarioPadre.getIdUsuario()));
		model.addAttribute("status","Has modificado correctamente tus datos,"+u.getUsername());
		return "index";
	}
	
	@GetMapping("/logOut")
	public String urlLogout(Model model) {
		model.addAttribute("usuario", new Usuario());
		model.addAttribute("status", "Hasta Pronto "+usuarioPadre.getNombre());
		return "login";
	}
	

}
