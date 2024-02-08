package com.chipilinsoft.middleware.component;

import java.time.LocalDateTime;
import java.util.List;

import com.chipilinsoft.middleware.entity.Jornada;
import com.chipilinsoft.middleware.entity.Partido;

public interface JornadaProvider {
	Jornada getJornadaActiva(String idGrupo);
	Jornada getLastJornada(String idGrupo);
	boolean saveJornada(String idGrupo, String nombre, LocalDateTime fechaCierre, List<Partido> partidos);
	boolean updateJornada(String idJornada, String nombre, LocalDateTime fechaCierre);
	boolean cerraJornada(String id);
}
