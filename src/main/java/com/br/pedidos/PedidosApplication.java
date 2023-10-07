package com.br.pedidos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class},
scanBasePackages = {
		"com.br.pedidos.entities",
		"com.br.pedidos.repository",
		"com.br.pedidos.controllers",
		"com.br.pedidos.services",
} )

@EnableJpaRepositories
public class PedidosApplication {

	public static void main(String[] args) {
		SpringApplication.run(PedidosApplication.class, args);
	}

}
