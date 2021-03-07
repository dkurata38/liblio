package com.github.dkurata38.liblio.application.library;

import org.springframework.stereotype.Service;
import com.github.dkurata38.liblio.domain.library.Library;
import com.github.dkurata38.liblio.domain.library.LibraryRepository;

@Service
public class LibraryService {

	private final LibraryRepository libraryRepository;

	public LibraryService(LibraryRepository libraryRepository) {
		this.libraryRepository = libraryRepository;
	}

	public Iterable<Library> getList() {
		return libraryRepository.findAll();
	}
}
