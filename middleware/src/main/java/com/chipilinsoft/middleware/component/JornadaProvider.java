package com.chipilinsoft.middleware.component;

import java.time.LocalDateTime;

import com.chipilinsoft.middleware.entity.Jornada;

public interface JornadaProvider {
	Jornada getJornadaActiva(String idGrupo);
	Jornada getLastJornada(String idGrupo);
	boolean saveJornada(String idGrupo, String nombre, LocalDateTime fechaCierre);
	boolean updateJornada(String idJornada, String nombre, LocalDateTime fechaCierre);
	boolean cerraJornada(String id);
}
