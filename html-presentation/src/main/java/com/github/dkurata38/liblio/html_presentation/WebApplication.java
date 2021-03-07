package com.github.dkurata38.liblio.html_presentation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import com.github.dkurata38.liblio.application.ApplicationConfig;
import com.github.dkurata38.liblio.infrastructure.InfrastructureConfig;

@SpringBootApplication
@Import(value = {InfrastructureConfig.class, ApplicationConfig.class})
public class WebApplication {
	public static void main(String[] args) {
		SpringApplication.run(WebApplication.class, args);
	}
}
