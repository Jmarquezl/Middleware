package com.chipilinsoft.middleware.entity;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class CrearJornadaResponse extends BaseResponse{
	private String id;
	private String nombre;
	private LocalDateTime fechaCierre;
}
