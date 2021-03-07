package com.github.dkurata38.liblio.infrastructure.domain.library;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Repository;
import com.github.dkurata38.liblio.domain.library.Library;
import com.github.dkurata38.liblio.domain.library.LibraryId;
import com.github.dkurata38.liblio.domain.library.LibraryName;
import com.github.dkurata38.liblio.domain.library.LibraryRepository;

@Repository
public class LibraryRepositoryImpl implements LibraryRepository {
	@Override
	public Iterable<Library> findAll() {
		return List.of(
				new Library(new LibraryId(""), new LibraryName("品川図書館"))
		);
	}

	@Override
	public Optional<Library> findById(LibraryId libraryId) {
		return Optional.empty();
	}
}
