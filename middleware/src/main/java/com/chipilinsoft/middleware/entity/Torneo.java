package com.chipilinsoft.middleware.entity;

import lombok.Data;

@Data
public class Torneo {
	private String id;
	private String nombre;
	
	public Torneo(String id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}
}
