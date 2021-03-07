package com.github.dkurata38.liblio.domain.library;

import java.util.Optional;

public interface LibraryRepository {
	Iterable<Library> findAll();
	Optional<Library> findById(LibraryId libraryId);
}
