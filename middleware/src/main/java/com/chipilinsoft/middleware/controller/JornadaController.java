package com.chipilinsoft.middleware.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.CurrentSecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chipilinsoft.middleware.entity.JornadaActivaRequest;
import com.chipilinsoft.middleware.service.JornadaService;

@RestController
@RequestMapping(value = "v1/jornada/")
public class JornadaController {
	private static final Logger logger = LoggerFactory.getLogger(JornadaController.class);
	@Autowired
	private JornadaService jornadaService;
	
	@GetMapping(value = "activa", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> jornadaActiva(@RequestParam String grupo, @CurrentSecurityContext SecurityContextHolder context){
		logger.info("Petición de consulta de jornada activa para el grupo: " + grupo + " conext user " + context.getContext().getAuthentication().getName());
		JornadaActivaRequest request = new JornadaActivaRequest();
		request.setGrupo(grupo);
		return new ResponseEntity<>(jornadaService.getJornadaActiva(request), HttpStatus.OK);
	}
	
}
