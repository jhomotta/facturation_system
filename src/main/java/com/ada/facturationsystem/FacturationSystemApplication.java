package com.ada.facturationsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class FacturationSystemApplication {
	public static void main(String[] args) {
		SpringApplication.run(FacturationSystemApplication.class, args);
	}
}
