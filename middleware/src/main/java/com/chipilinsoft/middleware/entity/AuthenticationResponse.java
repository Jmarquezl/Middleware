package com.chipilinsoft.middleware.entity;

import lombok.Data;

@Data
public class AuthenticationResponse implements IBaseResponse{
	private String token;
	private String nombre;
}
