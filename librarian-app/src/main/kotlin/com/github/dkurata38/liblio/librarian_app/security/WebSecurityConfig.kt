package com.github.dkurata38.liblio.librarian_app.security

import com.github.dkurata38.liblio.domain.librarian.LibrarianRepository
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder

@Configuration
@EnableWebSecurity
class WebSecurityConfig(private val librarianRepository: LibrarianRepository): WebSecurityConfigurerAdapter() {
    override fun configure(http: HttpSecurity) {
        http
            .formLogin {  }
            .authorizeRequests{
                it.anyRequest().authenticated()
            }
    }

    override fun configure(auth: AuthenticationManagerBuilder) {
        auth.userDetailsService(LibrarianUserDetailsService(librarianRepository))
            .passwordEncoder(passwordEncoder())
    }

    @Bean
    fun passwordEncoder(): PasswordEncoder? {
        return BCryptPasswordEncoder()
    }
}
