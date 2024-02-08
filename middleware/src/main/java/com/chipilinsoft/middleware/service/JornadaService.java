package com.chipilinsoft.middleware.service;

import com.chipilinsoft.middleware.entity.CrearJornadaRequest;
import com.chipilinsoft.middleware.entity.CrearJornadaResponse;
import com.chipilinsoft.middleware.entity.JornadaActivaRequest;
import com.chipilinsoft.middleware.entity.JornadaActivaResponse;

public interface JornadaService {
	public JornadaActivaResponse getJornadaActiva(JornadaActivaRequest request);
	public CrearJornadaResponse crearJornada(CrearJornadaRequest request);
}
