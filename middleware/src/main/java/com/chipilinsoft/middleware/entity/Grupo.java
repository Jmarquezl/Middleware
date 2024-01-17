package com.chipilinsoft.middleware.entity;

import lombok.Data;

@Data
public class Grupo {
	private String id;
	private String nombre;
	
	public Grupo(String id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}
}
