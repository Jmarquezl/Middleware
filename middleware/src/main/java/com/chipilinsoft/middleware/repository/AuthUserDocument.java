package com.chipilinsoft.middleware.repository;

import java.util.List;

import lombok.Data;

@Data
public class AuthUserDocument {
	private String uss;
	private String pss;
	private boolean administrador;
	private String identificador;
	private boolean dev;
	private List<AppUserRole> appUserRoles;
}
