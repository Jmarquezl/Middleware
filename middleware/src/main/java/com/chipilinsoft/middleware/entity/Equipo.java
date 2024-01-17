package com.chipilinsoft.middleware.entity;

import lombok.Data;

@Data
public class Equipo {
	private String id;
	private String nombre;
	
	public Equipo(String id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}
}
