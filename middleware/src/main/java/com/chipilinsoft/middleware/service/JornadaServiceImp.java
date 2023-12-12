package com.chipilinsoft.middleware.service;

import java.time.LocalDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.chipilinsoft.middleware.entity.JornadaActivaRequest;
import com.chipilinsoft.middleware.entity.JornadaActivaResponse;

@Service
public class JornadaServiceImp implements JornadaService{
	private static final Logger logger = LoggerFactory.getLogger(JornadaServiceImp.class);
	
	@Override
	public JornadaActivaResponse getJornadaActiva(JornadaActivaRequest request) {
		JornadaActivaResponse response = new JornadaActivaResponse();
		logger.info("Inicia la consulta de jornada activa del grupo: " + request.getGrupo());
		
		response.setId(1);
		response.setNombre("Jornada 1");
		response.setFechaLimite(LocalDate.now().plusDays(5));
		
		return response;
	}

}
