package com.github.dkurata38.liblio.infrastructure.domain.librarian;

import lombok.RequiredArgsConstructor;

import java.util.Optional;
import org.springframework.stereotype.Repository;
import com.github.dkurata38.liblio.domain.librarian.Librarian;
import com.github.dkurata38.liblio.domain.librarian.LibrarianId;
import com.github.dkurata38.liblio.domain.librarian.LibrarianRepository;
import com.github.dkurata38.liblio.domain.librarian.Password;
import com.github.dkurata38.liblio.domain.librarian.Username;
import com.github.dkurata38.liblio.domain.library.LibraryId;

@Repository
@RequiredArgsConstructor
public class LibrarianRepositoryImpl implements LibrarianRepository {
	private final LibrarianRecordMapper librarianRecordMapper;
	@Override
	public Optional<Librarian> findByUsername(Username username) {
		return Optional.ofNullable(librarianRecordMapper.selectByUsername(username.getValue()))
				.map(this::from);
	}

	Librarian from(LibrarianRecord librarianRecord) {
		return new Librarian(
				new LibrarianId(librarianRecord.getLibrarianId()),
				new LibraryId(librarianRecord.getLibraryId()),
				new Username(librarianRecord.getUsername()),
				new Password(librarianRecord.getPassword())
		);
	}
}
