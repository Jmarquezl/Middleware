package com.chipilinsoft.middleware.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.chipilinsoft.middleware.entity.Grupo;
import com.chipilinsoft.middleware.repository.GrupoDocument;
import com.chipilinsoft.middleware.repository.QuinieleroRepository;

@Component
public class GrupoProviderImp implements GrupoProvider{
	@Autowired
	private QuinieleroRepository quinieleroRepository;

	@Override
	public Grupo getGrupo(String id) {
		GrupoDocument grupo = quinieleroRepository.getGrupo(id);
		return new Grupo(grupo.getId(), grupo.getNombre());
	}

}
