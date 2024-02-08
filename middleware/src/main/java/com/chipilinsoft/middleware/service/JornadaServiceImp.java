package com.chipilinsoft.middleware.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chipilinsoft.middleware.component.JornadaProvider;
import com.chipilinsoft.middleware.component.MessageProvider;
import com.chipilinsoft.middleware.entity.CrearJornadaRequest;
import com.chipilinsoft.middleware.entity.CrearJornadaResponse;
import com.chipilinsoft.middleware.entity.Jornada;
import com.chipilinsoft.middleware.entity.JornadaActivaRequest;
import com.chipilinsoft.middleware.entity.JornadaActivaResponse;
import com.chipilinsoft.middleware.utils.CodeStatus;

@Service
public class JornadaServiceImp implements JornadaService{
	private static final Logger logger = LoggerFactory.getLogger(JornadaServiceImp.class);
	@Autowired
	private JornadaProvider jornadaProvider;
	@Autowired
	private MessageProvider messageProvider;
	
	@Override
	public JornadaActivaResponse getJornadaActiva(JornadaActivaRequest request) {
		JornadaActivaResponse response = new JornadaActivaResponse();
		try {			
			logger.info("Inicia la consulta de jornada activa del grupo: " + request.getGrupo());
			Jornada jornada = jornadaProvider.getJornadaActiva(request.getGrupo());
			logger.info("Jornada encontrada: " + jornada);
			if(jornada == null)
				messageProvider.assertCode(response, CodeStatus.JORNADA_NO_ACTIVA);
			else {				
				BeanUtils.copyProperties(jornada, response);
				messageProvider.assertCode(response, CodeStatus.GENERIC_OK);
			}
		} catch (Exception ex) {
			logger.error("Ocurrio un error al tratar de obtener la jornada activa del grupo " + request.getGrupo() + ex.getMessage());
			messageProvider.assertCode(response, CodeStatus.GENERIC_FAIL);
		}
		
		return response;
	}
	@Override
	public CrearJornadaResponse crearJornada(CrearJornadaRequest request) {
		CrearJornadaResponse response = new CrearJornadaResponse();
		try {			
			logger.info("Inicia la creación de jornada para el grupo : " + request.getGrupo());
			boolean success = jornadaProvider.saveJornada(request.getGrupo(), request.getNombre(), request.getFechaCierre(), request.getPartidos());
			logger.info("Jornada creada.");
			if(success)
				messageProvider.assertCode(response, CodeStatus.GENERIC_OK);
			else {				
				BeanUtils.copyProperties(request, response);
				messageProvider.assertCode(response, CodeStatus.GENERIC_FAIL);
			}
		} catch (Exception ex) {
			logger.error("Ocurrio un error al tratar de crear la jornada del grupo " + request.getGrupo() + ex.getMessage());
			messageProvider.assertCode(response, CodeStatus.GENERIC_FAIL);
		}
		
		return response;
	}

}
