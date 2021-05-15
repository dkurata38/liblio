package com.github.dkurata38.liblio.user_app.security

import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.User

class LiblioUser(
    val userId: String,
    username: String,
    password: String,
    enabled: Boolean,
    accountNonExpired: Boolean,
    credentialsNonExpired: Boolean,
    accountNonLocked: Boolean,
    authorities: MutableCollection<out GrantedAuthority>
) : User(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities) {
    constructor(userId: String, username: String,
                password: String, authorities: MutableCollection<out GrantedAuthority>): this(userId, username, password, true, true, true, true, authorities) {
    }
}
