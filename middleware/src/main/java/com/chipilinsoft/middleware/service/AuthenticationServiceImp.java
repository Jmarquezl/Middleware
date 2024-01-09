package com.chipilinsoft.middleware.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.chipilinsoft.middleware.component.MessageProvider;
import com.chipilinsoft.middleware.entity.AuthenticationRequest;
import com.chipilinsoft.middleware.entity.AuthenticationResponse;
import com.chipilinsoft.middleware.entity.BaseResponse;
import com.chipilinsoft.middleware.repository.AuthUserDocument;
import com.chipilinsoft.middleware.repository.UserRepo;
import com.chipilinsoft.middleware.security.JwtTokenProvider;

import ch.qos.logback.classic.sift.AppenderFactoryUsingJoran;

@Service
public class AuthenticationServiceImp implements AuthenticationServie{
	
	private static final Logger logger = LoggerFactory.getLogger(AuthenticationServiceImp.class);
			
	@Autowired
	private UserRepo userRepository;
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
			AuthUserDocument appUser = userRepository.getUser(request.getUss());
			if(appUser == null) return response;
			logger.info("Se obtiene el siguiente usuario: " + appUser.toString());
			UsernamePasswordAuthenticationToken usa = new UsernamePasswordAuthenticationToken(request.getUss(), request.getPss());
			logger.info(usa.getCredentials().toString());
			authenticationManager.authenticate(usa);
			
			token =  jwtTokenProvider.createToken(request.getUss(), appUser.getAppUserRoles());
			BeanUtils.copyProperties(appUser, response);
			response.setToken(token);
			message.assertCode(response, "001");
			logger.info(response.toString());
		} catch (Exception e) {
			message.assertCode(response, "002");
			logger.error("Error:: " + e.toString() + e.getMessage());
		}
		return response;
	}
	@Override
	public BaseResponse refreshToken(@RequestBody AuthenticationRequest request) {
		AuthenticationResponse response = new AuthenticationResponse();
		logger.info("Inicia el método de refresh toekn para el usuarir :" + request.getUss());
		try {
			AuthUserDocument appUser = userRepository.getUser(request.getUss());
			String token =  jwtTokenProvider.createToken(request.getUss(), appUser.getAppUserRoles());
			response.setNombre(appUser.getUss());
			response.setToken(token);
			message.assertCode(response, "001");
			logger.info(response.toString());
		} catch (Exception e) {
			message.assertCode(response, "002");
			logger.error("Error:: " + e.toString() + e.getMessage());
		}
		return response;
	}
}
