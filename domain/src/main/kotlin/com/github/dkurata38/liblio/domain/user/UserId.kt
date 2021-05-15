package com.github.dkurata38.liblio.domain.user

import java.util.*

data class UserId(val value: String) {

    init {
        require(value.isNotEmpty())
    }

    companion object {
        @JvmStatic
        fun generate(): UserId {
            return UserId(UUID.randomUUID().toString())
        }
    }
}

