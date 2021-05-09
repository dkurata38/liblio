package com.github.dkurata38.liblio.infrastructure.domain.librarian;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface LibrarianRecordMapper {
    LibrarianRecord selectByUsername(@Param("username") String username);
}
