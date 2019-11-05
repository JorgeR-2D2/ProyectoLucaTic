package com.lucatinder.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.logging.Logger;

import com.github.javafaker.Faker;
import com.lucatinder.util.RandomRange;

/**Esta clase nos permite crear perfiles falsos de forma automática
 * 
 * @author Jorge
 * @version 1.0
 * @date 20/10/2019 
 */
public class FactoriaUsuarioAutomatico {
	
	private static Faker creadorFaker=new Faker(new Locale("es"));
	private static Logger log=Logger.getLogger("FactoriaUsuarioAutomatico: -------");
	
	public FactoriaUsuarioAutomatico() {}
	
	/**Método encargado de devolver un único usuario falseado
	 * 
	 * @author Jorge
	 * @date 20/10/2019
	 * @return Usuario con datos falseados
	 */
	public static Usuario devuelveUsuarioAuto() {
		Usuario u=new Usuario();
		log.info("Iniciando Creación de Usuario Falseado");
	
		u.setNombre(creadorFaker.name().fullName());
		u.setEdad(RandomRange.devuelveEnRango(18, 60));
		u.setGenero((Math.random()>0.5)?"M":"F");
		u.setUsername("@Bot"+u.getNombre().replaceAll(" ","")+u.getEdad()+u.getGenero());
		u.setPassword(u.getUsername()+"pass");
		u.setDescripcion("Soy un bot, y estoy interesado en robar tus datos y venderlos");
		
		log.info("Devolviendo Usuario Falseado: ");
		log.info(u.getUsername());
		log.info(u.getPassword());
		log.info(u.getNombre());
		log.info(""+u.getEdad());
		log.info(u.getGenero());
		
		return u;
	}
	/**Método encargado de devolver "n" usuarios completos falseados
	 * @author Jorge
	 * @date 20/10/2019
	 * @param numeroUsuarios
	 * @return Lista de Usuarios Falseados con longitud personalizable
	 */
	public static List<Usuario> devuelveUsuariosAuto(int numeroUsuarios){
		List<Usuario> listaUsuariosAuto=new ArrayList<>();
		log.info("Generando Lista Usuarios Falseados. Longitud:"+numeroUsuarios);
		for (int i=0;i<numeroUsuarios;i++) {
			log.info("Insertando Usuario en lista");
			listaUsuariosAuto.add(devuelveUsuarioAuto());
		}
		log.info("Lista generada con éxito");
		log.info("Devolviendo lista de "+numeroUsuarios+" usuarios falseados");
		return listaUsuariosAuto;
	}
}
