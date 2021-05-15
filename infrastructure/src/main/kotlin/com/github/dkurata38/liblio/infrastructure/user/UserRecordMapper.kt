package com.github.dkurata38.liblio.infrastructure.user

import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Param

@Mapper
interface UserRecordMapper {
    fun selectByUsername(@Param("username") username: String): UserRecord?

    fun insert(userRecord: UserRecord): Int;
}
