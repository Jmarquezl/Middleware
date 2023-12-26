package com.chipilinsoft.middleware.repository;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document("Usuario")
public class AuthUserDocument {
	@Id
	private String id;
	private String uss;
	private String pss;
	private boolean admin;
	private String grupo;
	private String nombre;
	private String paterno;
	private String materno;
	private List<AppUserRole> appUserRoles;
}
