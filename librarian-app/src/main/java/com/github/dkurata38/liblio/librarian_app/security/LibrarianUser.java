package com.github.dkurata38.liblio.librarian_app.security;

import lombok.Getter;

import java.util.Collection;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class LibrarianUser extends User {
    @Getter
    private final String librarianId;

    @Getter
    private final String libraryId;

    public LibrarianUser(String librarianId, String libraryId, String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
        this.librarianId = librarianId;
        this.libraryId = libraryId;
    }

    public LibrarianUser(String librarianId, String libraryId, String username, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
        this.librarianId = librarianId;
        this.libraryId = libraryId;
    }
}
