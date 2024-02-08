package com.chipilinsoft.middleware;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

@SpringBootApplication
@ComponentScan
@EnableAutoConfiguration
public class MiddlewareApplication {

	public static void main(String[] args) {
		SpringApplication.run(MiddlewareApplication.class, args);
	}

}
