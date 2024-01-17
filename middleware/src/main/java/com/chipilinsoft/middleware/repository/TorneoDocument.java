package com.chipilinsoft.middleware.repository;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document("Torneo")
public class TorneoDocument {
	private String id;
	private String idGrupo;
	private String nombre;
}
