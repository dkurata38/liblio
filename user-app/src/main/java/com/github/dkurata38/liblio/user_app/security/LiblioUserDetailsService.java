package com.github.dkurata38.liblio.user_app.security;

import lombok.RequiredArgsConstructor;

import java.util.List;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import com.github.dkurata38.liblio.domain.user.UserRepository;
import com.github.dkurata38.liblio.domain.user.Username;

@RequiredArgsConstructor
public class LiblioUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(new Username(username))
            .map(user -> new LiblioUser(
                user.getUserId().getValue(),
                user.getUsername().getValue(),
                user.getPassword().getValue(),
                List.of(new SimpleGrantedAuthority("ROLE_USER"))
            ))
            .orElseThrow(() -> new UsernameNotFoundException("User is not found"));
    }
}
