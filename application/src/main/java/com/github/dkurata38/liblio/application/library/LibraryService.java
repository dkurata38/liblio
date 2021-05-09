package com.github.dkurata38.liblio.application.library;

import java.util.Optional;
import org.springframework.stereotype.Service;
import com.github.dkurata38.liblio.domain.library.Library;
import com.github.dkurata38.liblio.domain.library.LibraryId;
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

    public Optional<Library> getById(LibraryId libraryId) {
        return libraryRepository.findById(libraryId);
    }
}
