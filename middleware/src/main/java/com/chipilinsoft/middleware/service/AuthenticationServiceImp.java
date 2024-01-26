package com.chipilinsoft.middleware.service;

import java.util.ArrayList;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.chipilinsoft.middleware.component.EquipoProvider;
import com.chipilinsoft.middleware.component.GrupoProvider;
import com.chipilinsoft.middleware.component.JornadaProvider;
import com.chipilinsoft.middleware.component.MessageProvider;
import com.chipilinsoft.middleware.component.TorneoProvider;
import com.chipilinsoft.middleware.entity.AuthenticationRequest;
import com.chipilinsoft.middleware.entity.AuthenticationResponse;
import com.chipilinsoft.middleware.entity.BaseResponse;
import com.chipilinsoft.middleware.entity.Equipo;
import com.chipilinsoft.middleware.repository.AuthUserDocument;
import com.chipilinsoft.middleware.repository.GrupoDocument;
import com.chipilinsoft.middleware.repository.QuinieleroRepository;
import com.chipilinsoft.middleware.repository.TorneoDocument;
import com.chipilinsoft.middleware.security.JwtTokenProvider;
import com.chipilinsoft.middleware.utils.CodeStatus;

import ch.qos.logback.classic.sift.AppenderFactoryUsingJoran;

@Service
public class AuthenticationServiceImp implements AuthenticationServie{
	
	private static final Logger logger = LoggerFactory.getLogger(AuthenticationServiceImp.class);
			
	@Autowired
	private QuinieleroRepository quinieleroRepository;
	@Autowired
	private EquipoProvider equipoProvider;
	@Autowired
	private GrupoProvider grupoProvider;
	@Autowired
	private TorneoProvider torneoProvider;
	@Autowired
	private JornadaProvider jornadaProvider;
	@Autowired
	private JwtTokenProvider jwtTokenProvider;
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private MessageProvider message;
	  
	  
	@Override
	public BaseResponse login(AuthenticationRequest request) {
		AuthenticationResponse response = new AuthenticationResponse();
		try {
			String token = "";
			AuthUserDocument appUser = quinieleroRepository.getUser(request.getUss());
			if(appUser == null) return response;
			logger.info("Se obtiene el siguiente usuario: " + appUser.toString());
			UsernamePasswordAuthenticationToken usa = new UsernamePasswordAuthenticationToken(request.getUss(), request.getPss());
			authenticationManager.authenticate(usa);
			token =  jwtTokenProvider.createToken(request.getUss(), appUser.getAppUserRoles());
			BeanUtils.copyProperties(appUser, response);
			response.setUsuario(appUser.getUss());
			response.setEquipos(equipoProvider.getEquipos());
			response.setGrupo(grupoProvider.getGrupo(appUser.getGrupo()));
			response.setTorneo(torneoProvider.getTorneo(appUser.getGrupo()));
			response.setJornada(jornadaProvider.getJornadaActiva(appUser.getGrupo()));
			response.setToken(token);
			message.assertCode(response, CodeStatus.LOGIN_FAIL);
			logger.info(response.toString());
		} catch (Exception e) {
			message.assertCode(response, CodeStatus.LOGIN_FAIL);
			logger.error("Error:: " + e.toString() + e.getMessage());
		}
		return response;
	}
	@Override
	public BaseResponse refreshToken(@RequestBody AuthenticationRequest request) {
		AuthenticationResponse response = new AuthenticationResponse();
		logger.info("Inicia el método de refresh token para el usuarir :" + request.getUss());
		try {
			AuthUserDocument appUser = quinieleroRepository.getUser(request.getUss());
			String token =  jwtTokenProvider.createToken(request.getUss(), appUser.getAppUserRoles());
			response.setNombre(appUser.getUss());
			response.setToken(token);
			message.assertCode(response, CodeStatus.GENERIC_OK);
			logger.info(response.toString());
		} catch (Exception e) {
			message.assertCode(response, CodeStatus.REFRESH_TOKEN_FAIL);
			logger.error("Error:: " + e.toString() + e.getMessage());
		}
		return response;
	}
}
