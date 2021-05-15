package com.github.dkurata38.liblio.domain.user

interface UserRepository {
    /**
     * @param username not `null`
     * @return user
     */
    fun findByUsername(username: Username): User?

    /**
     * @param user not `null`
     */
    fun create(user: User)
}
