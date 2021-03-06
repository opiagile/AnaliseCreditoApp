package br.com.dock.analiseapp.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class AnaliseAppApiUsuarioApplication {

	public static void main(String[] args) {
		SpringApplication.run(AnaliseAppApiUsuarioApplication.class, args);
	}

}
