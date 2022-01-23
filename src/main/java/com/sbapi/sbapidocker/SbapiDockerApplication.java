package com.sbapi.sbapidocker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SbapiDockerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SbapiDockerApplication.class, args);
		System.out.println("Main is calling");
	}

}
