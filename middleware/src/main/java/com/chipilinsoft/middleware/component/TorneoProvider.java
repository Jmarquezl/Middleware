package com.chipilinsoft.middleware.component;

import com.chipilinsoft.middleware.entity.Torneo;

public interface TorneoProvider {
	Torneo getTorneo(String idGrupo);
}
