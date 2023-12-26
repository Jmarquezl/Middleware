package com.chipilinsoft.middleware.entity;

import lombok.Data;

@Data
public class AuthenticationResponse implements IBaseResponse{
	private String code;
	private String message;
	private String token;
	private String nombre;
}
