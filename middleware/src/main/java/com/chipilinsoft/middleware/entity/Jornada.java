package com.chipilinsoft.middleware.entity;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class Jornada {
	private String id;
	private String nombre;
	private LocalDateTime fechaCierre;
	private boolean activo;
	public Jornada(String id, String nombre, LocalDateTime fechaCierre, boolean activo) {
		this.id = id;
		this.nombre = nombre;
		this.fechaCierre = fechaCierre;
		this.activo = activo;
	}
}
