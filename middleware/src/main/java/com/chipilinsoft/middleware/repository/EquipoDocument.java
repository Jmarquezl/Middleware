package com.chipilinsoft.middleware.repository;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document("Equipo")
public class EquipoDocument {
	private String id;
	private String nombre;
	private String logo;
}
