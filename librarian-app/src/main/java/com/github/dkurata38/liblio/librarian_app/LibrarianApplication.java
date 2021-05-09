package com.github.dkurata38.liblio.librarian_app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import com.github.dkurata38.liblio.application.ApplicationConfig;
import com.github.dkurata38.liblio.infrastructure.InfrastructureConfig;

@SpringBootApplication
@Import({ApplicationConfig.class, InfrastructureConfig.class})
public class LibrarianApplication {
    public static void main(String[] args) {
        SpringApplication.run(LibrarianApplication.class, args);
    }
}
