package com.lucatinder.service;

import java.util.List;

import com.lucatinder.model.Match;
import com.lucatinder.model.Usuario;

public interface IMatchesService {
	
	public List<Usuario> devuelveMatches(int idUsuarioSolicitante);
	public void guardarMatch(Match m);
	public Match devuelveMatch(int idUsuarioSolicitante,int idUsuarioReceptor);
}
