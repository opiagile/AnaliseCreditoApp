package br.com.dock.analiseapp.discovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class AnaliseAppDiscoveryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AnaliseAppDiscoveryServiceApplication.class, args);
	}

}
