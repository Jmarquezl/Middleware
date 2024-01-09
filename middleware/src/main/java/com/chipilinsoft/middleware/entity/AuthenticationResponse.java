package com.chipilinsoft.middleware.entity;

import lombok.Data;

@Data
public class AuthenticationResponse extends BaseResponse{	
	private String token;
	
	private String id;
	private String nombre;
	
	private boolean admin;
	private String grupo;
	private String paterno;
	private String materno;
}
