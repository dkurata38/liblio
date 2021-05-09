package com.github.dkurata38.liblio.librarian_app.security;

import lombok.RequiredArgsConstructor;

import java.util.List;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import com.github.dkurata38.liblio.domain.librarian.LibrarianRepository;
import com.github.dkurata38.liblio.domain.librarian.Username;

@RequiredArgsConstructor
public class LibrarianUserDetailsService implements UserDetailsService {
    private final LibrarianRepository librarianRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return librarianRepository.findByUsername(new Username(username))
            .map(librarian -> new LibrarianUser(
                librarian.getLibrarianId().getValue(),
                librarian.getUsername().getValue(),
                librarian.getPassword().getValue(),
                List.of(new SimpleGrantedAuthority("ROLE_USER"))
            ))
            .orElseThrow(() -> new UsernameNotFoundException("user is not found"));
    }
}
