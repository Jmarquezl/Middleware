package com.chipilinsoft.middleware.component;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.chipilinsoft.middleware.entity.Jornada;
import com.chipilinsoft.middleware.entity.Partido;
import com.chipilinsoft.middleware.repository.JornadaDocument;
import com.chipilinsoft.middleware.repository.QuinieleroRepository;

@Component
public class JornadaProviderImp implements JornadaProvider{
	@Autowired
	private QuinieleroRepository quinieleroRepository;
	
	@Override
	public Jornada getJornadaActiva(String idGrupo) {
		JornadaDocument jornada = quinieleroRepository.getJornadaActiva(idGrupo);	
		if(jornada == null) 
			return null;
		else
			return new Jornada(jornada.getId(), jornada.getNombre(), jornada.getFechaCierre(), jornada.isActivo());
	}

	@Override
	public Jornada getLastJornada(String idGrupo) {
		JornadaDocument jornada = quinieleroRepository.getLastJornada(idGrupo);
		if(jornada == null) 
			return null;
		else
			return new Jornada(jornada.getId(), jornada.getNombre(), jornada.getFechaCierre(), jornada.isActivo());
	}

	@Override
	public boolean saveJornada(String idGrupo, String nombre, LocalDateTime fechaCierre, List<Partido> partidos) {
		return quinieleroRepository.saveJornada(idGrupo, nombre, fechaCierre, partidos);
	}

	@Override
	public boolean updateJornada(String idJornada, String nombre, LocalDateTime fechaCierre) {
		return quinieleroRepository.updateJornada(idJornada, nombre, fechaCierre);
	}

	@Override
	public boolean cerraJornada(String id) {
		return quinieleroRepository.cerraJornada(id);
	}

}
