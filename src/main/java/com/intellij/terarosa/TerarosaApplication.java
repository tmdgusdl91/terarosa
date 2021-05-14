package com.intellij.terarosa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class TerarosaApplication {

	public static void main(String[] args) {
		SpringApplication.run(TerarosaApplication.class, args);
	}

}
