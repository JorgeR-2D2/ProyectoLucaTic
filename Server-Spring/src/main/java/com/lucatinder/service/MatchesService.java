package com.lucatinder.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucatinder.dao.IMatchDao;
import com.lucatinder.model.Match;
import com.lucatinder.model.Usuario;

@Service
public class MatchesService implements IMatchesService {

	@Autowired
	private IMatchDao matchDao;
	
	
	@Override
	public List<Usuario> devuelveMatches(int idUsuarioSolicitante) {
		List<Match> listaMatches=matchDao.devuelveListadoMatches(idUsuarioSolicitante);
		List<Usuario> listaUsuariosMatch=new ArrayList<>();
		
		for(Match m:listaMatches) {
			if(m.getUsuarioSolicitante().getIdUsuario()==idUsuarioSolicitante) {
				listaUsuariosMatch.add(m.getUsuarioReceptor());
			}else {
				listaUsuariosMatch.add(m.getUsuarioSolicitante());
			}
		}
		
		return listaUsuariosMatch;
	}


	@Override
	public void guardarMatch(Match m) {
		matchDao.save(m);
		
	}


	@Override
	public Match devuelveMatch(int idUsuarioSolicitante, int idUsuarioReceptor) {
		
		return matchDao.devuelveMatchPorContacto(idUsuarioSolicitante, idUsuarioReceptor);
	}


}
