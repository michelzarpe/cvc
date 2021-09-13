package br.com.cvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class CvcConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CvcConfigServerApplication.class, args);
	}

}
