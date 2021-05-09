package com.github.dkurata38.liblio.infrastructure.domain.librarian;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class LibrarianRecord {
	String librarianId;
	String libraryId;
	String username;
	String password;
	LocalDateTime createdAt;
	LocalDateTime updatedAt;
}
