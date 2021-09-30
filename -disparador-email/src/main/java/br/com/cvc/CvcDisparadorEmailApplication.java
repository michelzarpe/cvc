package br.com.cvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class CvcDisparadorEmailApplication {

	public static void main(String[] args) {
		SpringApplication.run(CvcDisparadorEmailApplication.class, args);
	}

}
