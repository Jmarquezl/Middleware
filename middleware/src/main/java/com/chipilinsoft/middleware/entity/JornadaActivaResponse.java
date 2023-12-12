package com.chipilinsoft.middleware.entity;

import java.time.LocalDate;

import lombok.Data;

@Data
public class JornadaActivaResponse implements IBaseResponse{
	private int id;
	private String nombre;
	private LocalDate fechaLimite;
}
