package com.chipilinsoft.middleware.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.chipilinsoft.middleware.entity.Torneo;
import com.chipilinsoft.middleware.repository.QuinieleroRepository;
import com.chipilinsoft.middleware.repository.TorneoDocument;

@Component
public class TorneoProviderImp implements TorneoProvider{
	@Autowired
	private QuinieleroRepository quinieleroRepository;

	@Override
	public Torneo getTorneo(String idGrupo) {
		TorneoDocument torneo = quinieleroRepository.getTorneo(idGrupo);
		return new Torneo(torneo.getId(), torneo.getNombre());
	}
}
