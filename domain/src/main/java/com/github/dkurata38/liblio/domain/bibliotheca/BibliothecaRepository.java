package com.github.dkurata38.liblio.domain.bibliotheca;

import com.github.dkurata38.liblio.domain.library.LibraryId;

public interface BibliothecaRepository {
    Iterable<Bibliotheca> findByLibraryId(LibraryId libraryId);
}
