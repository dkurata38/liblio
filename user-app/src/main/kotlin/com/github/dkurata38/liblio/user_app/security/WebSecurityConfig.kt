package com.github.dkurata38.liblio.user_app.security

import com.github.dkurata38.liblio.domain.user.UserRepository
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder

@Configuration
@EnableWebSecurity
class WebSecurityConfig(private val userRepository: UserRepository): WebSecurityConfigurerAdapter() {
    override fun configure(http: HttpSecurity) {
        http
            .formLogin { }
            .authorizeRequests {
                it
                    .antMatchers("/", "/register").permitAll()
                    .anyRequest().authenticated()
            }
    }

    override fun configure(auth: AuthenticationManagerBuilder) {
        auth
            .userDetailsService(LiblioUserDetailsService(userRepository))
            .passwordEncoder(passwordEncoder())
    }

    @Bean
    override fun authenticationManagerBean(): AuthenticationManager {
        return super.authenticationManagerBean()
    }

    @Bean
    fun passwordEncoder(): PasswordEncoder {
        return BCryptPasswordEncoder()
    }
}
