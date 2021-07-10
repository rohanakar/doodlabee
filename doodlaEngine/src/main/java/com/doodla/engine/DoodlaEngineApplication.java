package com.doodla.engine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;

@SpringBootApplication
public class DoodlaEngineApplication {

	public static void main(String[] args) {
		SpringApplication.run(DoodlaEngineApplication.class, args);
	}
	@Bean
	public PasswordEncoder encoder() {
	    return new Pbkdf2PasswordEncoder("secret", 1000, 128);
	}

}
