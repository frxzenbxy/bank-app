package com.example.rstroybackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class RStroyBackendApplication {
	public static void main(String[] args) {
		SpringApplication.run(RStroyBackendApplication.class, args);
	}
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry
						.addMapping("/api/v1/**")
						.allowCredentials(true)
						.allowedMethods("*")
						.maxAge(3600)
						.allowedOrigins("http://localhost:3000"); // User and Admin app
			}
		};
	}
}
