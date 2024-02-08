package com.chipilinsoft.middleware.component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.chipilinsoft.middleware.entity.Equipo;
import com.chipilinsoft.middleware.repository.EquipoDocument;
import com.chipilinsoft.middleware.repository.QuinieleroRepository;

@Component
@Lazy
public class EquipoProviderImp implements EquipoProvider{
	private static final Logger logger = LoggerFactory.getLogger(EquipoProviderImp.class);
	private List<EquipoDocument> equipos = new ArrayList<>();
	
	@Autowired
	private QuinieleroRepository quinieleroRepository;
	
	public EquipoProviderImp() {
		
	}
	
	//@PostConstruct
	private void cargaInicial() {
		logger.info("Consulta de equipos");
		try {			
			equipos = quinieleroRepository.getEquipos();
		} catch (Exception e) {
			logger.error("Error al consultar los equipos: ", e.getMessage());
		}
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
