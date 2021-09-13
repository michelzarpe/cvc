package br.com.cvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class CvcViagensApplication {

	public static void main(String[] args) {
		SpringApplication.run(CvcViagensApplication.class, args);
	}

}
