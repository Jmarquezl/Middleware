package com.chipilinsoft.middleware.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.chipilinsoft.middleware.entity.AuthenticationRequest;
import com.chipilinsoft.middleware.entity.AuthenticationResponse;
import com.chipilinsoft.middleware.entity.IBaseResponse;
import com.chipilinsoft.middleware.repository.AuthUserDocument;
import com.chipilinsoft.middleware.repository.UserRepo;
import com.chipilinsoft.middleware.security.JwtTokenProvider;

@Service
public class AuthenticationServiceImp implements AuthenticationServie{
	
	private static final Logger logger = LoggerFactory.getLogger(AuthenticationServiceImp.class);
			
	@Autowired
	private UserRepo userRepository;
	@Autowired
	private JwtTokenProvider jwtTokenProvider;
	@Autowired
	private AuthenticationManager authenticationManager;
	  
	  
	@Override
	public IBaseResponse login(AuthenticationRequest request) {
		AuthenticationResponse response = new AuthenticationResponse();
		logger.info("Request: " + request.toString());
		try {
			String token = "";
			AuthUserDocument appUser = userRepository.getUser(request.getUss(), request.getPss());
			logger.info("Se obtiene el siguiente usuario: " + appUser.toString());
			if(appUser == null)return response;
			
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUss(), request.getPss()));
			logger.info("sdasdasd");
			
			token =  jwtTokenProvider.createToken(request.getUss(), appUser.getAppUserRoles());
			response.setNombre(appUser.getUss());
			response.setToken(token);
			logger.info(response.toString());
		} catch (Exception e) {
			logger.error("Error: " + e.getMessage());
		}
		return response;
	}
}
