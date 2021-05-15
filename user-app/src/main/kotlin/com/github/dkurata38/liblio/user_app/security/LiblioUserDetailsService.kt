package com.github.dkurata38.liblio.user_app.security

import com.github.dkurata38.liblio.domain.user.UserRepository
import com.github.dkurata38.liblio.domain.user.Username
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException

class LiblioUserDetailsService(private val userRepository: UserRepository): UserDetailsService {
    override fun loadUserByUsername(username: String?): UserDetails {
        if (username == null) {
            throw NullPointerException()
        }
        val user = userRepository.findByUsername(Username(username)) ?: throw UsernameNotFoundException("User is not found")
        return LiblioUser(
            user.userId.value,
            user.username.value,
            user.password.value,
            mutableListOf(SimpleGrantedAuthority("ROLE_USER"))
        )
    }
}
