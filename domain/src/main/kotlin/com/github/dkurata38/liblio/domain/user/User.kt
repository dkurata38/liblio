package com.github.dkurata38.liblio.domain.user

class User(
    val userId: UserId,
    val username: Username,
    val password: Password,
    val mailAddress: MailAddress
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as User

        if (userId != other.userId) return false

        return true
    }

    override fun hashCode(): Int {
        return userId.hashCode()
    }

    override fun toString(): String {
        return "User(userId=$userId, username=$username, password=$password, mailAddress=$mailAddress)"
    }


}
