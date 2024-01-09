package com.chipilinsoft.middleware.entity;

import lombok.Data;

@Data
public class BaseResponse {
	private String code;
	private String message;
	private String folio;
}
