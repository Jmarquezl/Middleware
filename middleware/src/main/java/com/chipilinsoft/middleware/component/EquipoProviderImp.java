package com.chipilinsoft.middleware.component;

import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.chipilinsoft.middleware.entity.Equipo;
import com.chipilinsoft.middleware.repository.EquipoDocument;
import com.chipilinsoft.middleware.repository.QuinieleroRepository;

@Component
public class EquipoProviderImp implements EquipoProvider{
	private static final Logger logger = LoggerFactory.getLogger(EquipoProviderImp.class);
	private List<EquipoDocument> equipos;
	
	@Autowired
	private QuinieleroRepository quinieleroRepository;
	
	public EquipoProviderImp() {
		
	}
	
	@PostConstruct
	private void cargaInicial() {
		logger.info("Consulta de equipos");
		equipos = quinieleroRepository.getEquipos();
		logger.info("Se encontraron : " + equipos.size() + " equipos");
	}
	@Override
	public List<Equipo> getEquipos() {
		return equipos.stream().map(e -> new Equipo(e.getId(), e.getNombre())).collect(Collectors.toList());
	}

	@Override
	public String saveEquipo(String nombre) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteEquipo(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateEquipo(String id, String nombre) {
		// TODO Auto-generated method stub
		
	}

}
