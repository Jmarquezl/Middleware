package com.chipilinsoft.middleware.repository;

import java.util.List;

public interface QuinieleroRepository 
{
	AuthUserDocument getUser(String user);
	GrupoDocument getGrupo(String id);
	TorneoDocument getTorneo(String idGrupo);
	List<EquipoDocument> getEquipos();
}
