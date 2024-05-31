package com.curso.inicio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
/**
 * 
 * @author Admin
 *
 */
@EntityScan(basePackages = "com.curso.model")
@EnableJpaRepositories(basePackages = "com.curso.dao")
@SpringBootApplication(scanBasePackages = {"com.curso.controller","com.curso.service"})
public class EjercicioCursosApplication {

	public static void main(String[] args) {
		SpringApplication.run(EjercicioCursosApplication.class, args);
	}

}
