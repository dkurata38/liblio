package com.github.dkurata38.liblio.infrastructure.domain.user;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserRecord {
	private String userId;
	private String username;
	private String password;
	private String mailAddress;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
}
