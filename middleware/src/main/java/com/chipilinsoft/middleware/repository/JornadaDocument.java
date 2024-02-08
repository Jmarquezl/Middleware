package com.chipilinsoft.middleware.repository;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.chipilinsoft.middleware.entity.Partido;

import lombok.Data;

@Data
@Document("Jornada")
public class JornadaDocument {
	@Id
	private String id;
	private String idGrupo;
	private String nombre;
	private Instant fechaCreacion;
	
	private Instant fechaCierre;
	private List<Partido> partidos;
	private boolean activo;
	
	public JornadaDocument(String idGrupo, String nombre, Instant fechaCierre, List<Partido> partidos) {
		super();
		this.idGrupo = idGrupo;
		this.nombre = nombre;
		this.fechaCierre = fechaCierre;
		this.fechaCreacion = LocalDateTime.now().toInstant(ZoneOffset.UTC);
		this.partidos = partidos;
		this.activo = true;
	}
}
