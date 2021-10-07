package br.com.cvc;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableEurekaClient
@EnableFeignClients
@SpringBootApplication
public class CvcClienteApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(CvcClienteApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
	}

}
