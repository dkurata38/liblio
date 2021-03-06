package com.github.dkurata38.liblio.librarian_app

import com.github.dkurata38.liblio.application.ApplicationConfig
import com.github.dkurata38.liblio.infrastructure.InfrastructureConfig
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Import

@SpringBootApplication
@Import(ApplicationConfig::class, InfrastructureConfig::class)
class LibrarianApplication

fun main(args: Array<String>) {
    runApplication<LibrarianApplication>(*args)
}
