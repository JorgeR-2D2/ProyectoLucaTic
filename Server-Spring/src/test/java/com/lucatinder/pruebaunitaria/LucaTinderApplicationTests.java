package com.lucatinder.pruebaunitaria;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.lucatinder.dao.IUsuarioDao;
import com.lucatinder.model.Contactos;
import com.lucatinder.model.Usuario;
import com.lucatinder.service.IContactoService;
import com.lucatinder.service.UsuarioService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LucaTinderApplicationTests {
    
	@Autowired
	private UsuarioService service;

	@Autowired
	private IUsuarioDao dao;
	
	@Autowired
	private IContactoService contactoService;

/**
 * Prueba Unitaria para comprobar como se insertan usuarios automáticamente
 * @author Yolanda
 * @date 18/10/2019
 * 
 */
	/*@Test
	public void pruebaInsertarUsuario() {

		Usuario u = FactoriaUsuarioAutomatico.devuelveUsuarioAuto();
		long longitud = dao.count();
		service.guardarUsuario(u);

		assertTrue(longitud == dao.count() - 1);
	}*/

	/**
	 * Prueba Unitaria para comprobar el guardado de un usuario automático
	 * 
	 * @author Jorge
	 * @date 20/10/2019
	 * 
	 */
	/*@Test
	public void guardarUsuario() {
		Usuario u = FactoriaUsuarioAutomatico.devuelveUsuarioAuto();
		service.guardarUsuario(u);

	}*/

	/**
	 * Prueba Unitaria para comprobar el guardado de múltiples usuarios automáticos
	 * 
	 * @author Jorge
	 * @date 20/10/2019
	 * 
	 */
	/*@Test
	public void guardarListaUsuarios() {
		service.guardarUsuariosAutomaticos(FactoriaUsuarioAutomatico.devuelveUsuariosAuto(5));

	}*/
	
	/**
	 * Prueba Unitaria para comprobar la asignación de un contacto
	 * 
	 * @author Jorge
	 * @date 20/10/2019
	 * 
	 */
	/*@Test
	public void asignarContactoNuevo() {
		
		Contactos contactoNuevo=new Contactos();
		contactoNuevo.setUsuarioContactante(service.devuelveUsuarioId(15));
		contactoNuevo.setUsuarioContactado(service.devuelveUsuarioId(17));
		
		contactoService.contactar(contactoNuevo);
		
		
		
	}*/
	/**
	 * Prueba Unitaria para comprobar la devolución de la lista de contactos
	 * según el id del contactante
	 * 
	 * @author Jorge
	 * @date 20/10/2019
	 * 
	 */
	@Test
	public void retornaListaContactos() {
		
		List<Usuario> contactos=contactoService.devuelveListaContactos(15);
		
		assertTrue(contactos.get(0)!=null);
	}
	/*
	@Test
	public void compruebaMatch() {
		
		Contactos c1=new Contactos();
		c1.setUsuarioContactante(service.devuelveUsuarioId(25));
		c1.setUsuarioContactado(service.devuelveUsuarioId(21));
		contactoService.contactar(c1);
		
		Contactos c2=new Contactos();
		c2.setUsuarioContactante(service.devuelveUsuarioId(15));
		c2.setUsuarioContactado(service.devuelveUsuarioId(17));
		contactoService.contactar(c2);
		
		Contactos c3=new Contactos();
		c3.setUsuarioContactante(service.devuelveUsuarioId(19));
		c3.setUsuarioContactado(service.devuelveUsuarioId(20));
		contactoService.contactar(c3);
		/*
		Contactos c4=new Contactos();
		c4.setUsuarioContactante(service.devuelveUsuarioId(19));
		c4.setUsuarioContactado(service.devuelveUsuarioId(20));
		contactoService.contactar(c4);
	}*/
	
}
