package com.skilldistillery.bunker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.skilldistillery.bunker")
public class BunkerApplication {

	public static void main(String[] args) {
		SpringApplication.run(BunkerApplication.class, args);
	}

}
