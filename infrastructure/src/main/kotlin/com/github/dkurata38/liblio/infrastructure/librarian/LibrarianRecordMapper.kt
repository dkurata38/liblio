package com.github.dkurata38.liblio.infrastructure.librarian

import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Param

@Mapper
interface LibrarianRecordMapper {
    fun selectByUsername(@Param("username") username: String?): LibrarianRecord?
}
