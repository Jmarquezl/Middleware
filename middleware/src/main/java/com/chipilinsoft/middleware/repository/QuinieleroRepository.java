package com.chipilinsoft.middleware.repository;

import java.time.LocalDateTime;
import java.util.List;

public interface QuinieleroRepository 
{
	AuthUserDocument getUser(String user);
	GrupoDocument getGrupo(String id);
	TorneoDocument getTorneo(String idGrupo);
	List<EquipoDocument> getEquipos();
	JornadaDocument getJornadaActiva(String idGrupo);
	JornadaDocument getLastJornada(String idGrupo);
	boolean saveJornada(String idGrupo, String nombre, LocalDateTime fechaCierre);
	boolean updateJornada(String idJornada, String nombre, LocalDateTime fechaCierre);
	boolean cerraJornada(String id);
	List<CodeMessagesDocument> getCodigosError();
}
