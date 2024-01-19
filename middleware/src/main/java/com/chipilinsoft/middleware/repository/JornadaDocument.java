package com.chipilinsoft.middleware.repository;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document("Jornada")
public class JornadaDocument {
	@Id
	private String id;
	private String idGrupo;
	private String nombre;
	private LocalDateTime fechaCreacion;
	private LocalDateTime fechaCierre;
	private boolean activo;
	
	public JornadaDocument(String idGrupo, String nombre, LocalDateTime fechaCierre) {
		super();
		this.idGrupo = idGrupo;
		this.nombre = nombre;
		this.fechaCierre = fechaCierre;
	}
}
