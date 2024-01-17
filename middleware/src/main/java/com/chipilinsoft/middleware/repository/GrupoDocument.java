package com.chipilinsoft.middleware.repository;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("Grupo")
public class GrupoDocument {
	private String id;
	private String nombre;
}
