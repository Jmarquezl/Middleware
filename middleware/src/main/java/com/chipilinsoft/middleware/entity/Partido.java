package com.chipilinsoft.middleware.entity;

import lombok.Data;

@Data
public class Partido {
	private String local;
	private String visita;
	
	public Partido(String local, String visita){
		super();
		this.local = local;
		this.visita = visita;
	}
}
