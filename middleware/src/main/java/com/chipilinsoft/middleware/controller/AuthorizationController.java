package com.chipilinsoft.middleware.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("authorization")
public class AuthorizationController {

	@GetMapping(value = "saludo")
	public ResponseEntity<?> saludo(@RequestParam String name)
	{
		
		return new ResponseEntity<String>("Hola " + name, HttpStatus.OK);
	}
}
