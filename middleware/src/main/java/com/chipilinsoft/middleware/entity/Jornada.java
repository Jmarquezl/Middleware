package com.chipilinsoft.middleware.entity;

import java.time.Instant;
import java.time.LocalDateTime;

import lombok.Data;

@Data
public class Jornada {
	private String id;
	private String nombre;
	private Instant fechaCierre;
	private boolean activo;
	public Jornada(String id, String nombre, Instant fechaCierre, boolean activo) {
		this.id = id;
		this.nombre = nombre;
		this.fechaCierre = fechaCierre;
		this.activo = activo;
	}
}
