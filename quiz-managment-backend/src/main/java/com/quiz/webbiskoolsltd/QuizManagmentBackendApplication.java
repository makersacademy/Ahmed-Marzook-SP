package com.quiz.webbiskoolsltd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableWebSecurity
public class QuizManagmentBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuizManagmentBackendApplication.class, args);
	}

}
