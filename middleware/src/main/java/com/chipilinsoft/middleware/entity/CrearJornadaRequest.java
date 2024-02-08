package com.chipilinsoft.middleware.entity;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class CrearJornadaRequest implements IBaseRequest{
	private String nombre;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime fechaCierre;
	private String grupo;
	private List<Partido> partidos;
}
