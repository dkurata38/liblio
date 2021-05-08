package com.github.dkurata38.liblio.infrastructure.domain.user;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserRecordMapper {
	UserRecord selectByUsername(@Param("username") String username);
}
