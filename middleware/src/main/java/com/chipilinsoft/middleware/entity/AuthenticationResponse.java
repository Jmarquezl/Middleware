package com.chipilinsoft.middleware.entity;

import java.util.List;

import lombok.Data;

@Data
public class AuthenticationResponse extends BaseResponse{	
	private String token;
	
	private String id;
	private String usuario;
	private String nombre;
	private String paterno;
	private String materno;
	private boolean admin;
	private boolean quinielaActiva;
	private List<Equipo> equipos;
	private Grupo grupo;
	private Torneo torneo;
	private Jornada jornada;
}
