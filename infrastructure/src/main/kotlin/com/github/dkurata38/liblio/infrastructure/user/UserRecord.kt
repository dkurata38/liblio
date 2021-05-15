/*
 * Auto-generated file. Created by MyBatis Generator
 */
package com.github.dkurata38.liblio.infrastructure.user

import java.time.LocalDateTime

data class UserRecord(
    var userId: String? = null,
    var username: String? = null,
    var password: String? = null,
    var mailAddress: String? = null,
    var createdAt: LocalDateTime? = null,
    var updatedAt: LocalDateTime? = null
)