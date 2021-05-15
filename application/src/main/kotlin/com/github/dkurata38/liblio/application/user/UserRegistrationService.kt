package com.github.dkurata38.liblio.application.user

import com.github.dkurata38.liblio.domain.user.*
import org.springframework.stereotype.Service
import java.lang.IllegalArgumentException

@Service
class UserRegistrationService(private val userRepository: UserRepository) {
    fun register(username: Username, password: Password, mailAddress: MailAddress): UserId {
        val found = userRepository.findByUsername(username)
        if (found != null) {
            throw IllegalArgumentException()
        }
        val userId = UserId.generate()
        val user = User(userId, username, password, mailAddress)
        userRepository.create(user)
        return userId
    }
}
