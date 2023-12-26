package com.chipilinsoft.middleware.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chipilinsoft.middleware.entity.AuthenticationRequest;
import com.chipilinsoft.middleware.service.AuthenticationServie;

@RestController
@RequestMapping("public/authorization")
public class AuthorizationController {
	private static final Logger logger = LoggerFactory.getLogger(AuthorizationController.class);
	@Autowired
	private AuthenticationServie authenticationService;
	
	@PostMapping(value = "/login", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> login(@RequestBody AuthenticationRequest request){
		logger.info("Se recibe petición de login.");
		return new ResponseEntity<>(authenticationService.login(request), HttpStatus.OK);
	}
	
	@PostMapping(value = "/refreshToken", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> refreshToken(@RequestBody AuthenticationRequest request){
		logger.info("Se recibe petición para refresh token del usuario: " + request.getUss());
		return new ResponseEntity<>(authenticationService.refreshToken(request), HttpStatus.OK);
	}
}
