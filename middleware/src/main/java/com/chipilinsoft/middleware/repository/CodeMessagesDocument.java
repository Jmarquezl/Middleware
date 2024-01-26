package com.chipilinsoft.middleware.repository;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document("CodeMessages")
public class CodeMessagesDocument {
	@Id
	private String id;
	private String codigo;
	private String mensaje; 
}
