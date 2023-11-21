package com.chipilinsoft.middleware.repository;

import lombok.Data;

@Data
public class AuthUserDocument {
	private boolean administrador;
	private String identificador;
	private boolean dev;
}
