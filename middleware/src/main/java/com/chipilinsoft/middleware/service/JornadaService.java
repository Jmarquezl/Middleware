package com.chipilinsoft.middleware.service;

import com.chipilinsoft.middleware.entity.JornadaActivaRequest;
import com.chipilinsoft.middleware.entity.JornadaActivaResponse;

public interface JornadaService {
	public JornadaActivaResponse getJornadaActiva(JornadaActivaRequest request);
}
