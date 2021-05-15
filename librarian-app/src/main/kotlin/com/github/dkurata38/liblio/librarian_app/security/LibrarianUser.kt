package com.github.dkurata38.liblio.librarian_app.security

import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.User

class LibrarianUser(
    val librarianId: String,
    val libraryId: String,
    username: String,
    password: String,
    enabled: Boolean,
    accountNonExpired: Boolean,
    credentialsNonExpired: Boolean,
    accountNonLocked: Boolean,
    authorities: MutableCollection<out GrantedAuthority>
) : User(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities) {
    constructor(librarianId: String, libraryId: String, username: String,
                password: String, authorities: MutableCollection<out GrantedAuthority>): this(librarianId, libraryId, username, password, true, true, true, true, authorities)
}
