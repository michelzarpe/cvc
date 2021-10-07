package br.com.cvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class CvcEurekaServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CvcEurekaServiceApplication.class, args);
	}

}
