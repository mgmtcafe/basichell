package com.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
public class SpringBootHelloWorldApp {
	public static void main(String[] args) {
        SpringApplication.run(SpringBootHelloWorldApp.class, args);
    }

}
