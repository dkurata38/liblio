package com.github.dkurata38.liblio.infrastructure.user

import com.github.dkurata38.liblio.domain.user.*
import org.springframework.stereotype.Repository

@Repository
class UserRepositoryImpl(private val userRecordMapper: UserRecordMapper): UserRepository {
    override fun findByUsername(username: Username): User? {
        val userRecord = userRecordMapper.selectByUsername(username.value)
        return if (userRecord != null) {
            User(
                UserId(userRecord.userId!!),
                Username(userRecord.username!!),
                Password(userRecord.password!!),
                MailAddress(userRecord.mailAddress!!)
            )
        } else {
            null
        }
    }

    override fun create(user: User) {
        userRecordMapper.insert(UserRecord(
            user.userId.value,
            user.username.value,
            user.password.value,
            user.mailAddress.value
        ))
    }
}
