package com.api.salao;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Salão API", version = "2.0", description = "Salão de Beleza"))
public class SalaoApiApplication {
	public static void main(String[] args) {
		SpringApplication.run(SalaoApiApplication.class, args);
	}


}
