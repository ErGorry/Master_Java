package com.curso.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
/**
 * Inicio de la aplicacion de Formacion, se conecta con el servicio de Cursos
 * @author Admin
 *
 */
@EntityScan(basePackages = "com.curso.model")
@SpringBootApplication(scanBasePackages = {"com.curso.controller","com.curso.service"})
public class EjercicioFormacionApplication {

	public static void main(String[] args) {
		SpringApplication.run(EjercicioFormacionApplication.class, args);
	}
	@Bean
	RestTemplate template() {
		return new RestTemplate();
	}

}
