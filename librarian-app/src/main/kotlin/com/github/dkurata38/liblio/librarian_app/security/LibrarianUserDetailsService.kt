package com.github.dkurata38.liblio.librarian_app.security

import com.github.dkurata38.liblio.domain.librarian.LibrarianRepository
import com.github.dkurata38.liblio.domain.librarian.Username
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException

class LibrarianUserDetailsService(private val librarianRepository: LibrarianRepository): UserDetailsService {
    override fun loadUserByUsername(username: String?): UserDetails {
        requireNotNull(username)
        val user = librarianRepository.findByUsername(Username(username)) ?: throw UsernameNotFoundException("User is not found")
        return LibrarianUser(
            user.librarianId.value,
            user.libraryId.value,
            user.username.value,
            user.password.value,
            mutableListOf(SimpleGrantedAuthority("ROLE_USER"))
        )
    }
}
