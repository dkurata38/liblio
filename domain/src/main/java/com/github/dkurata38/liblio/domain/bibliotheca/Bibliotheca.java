package com.github.dkurata38.liblio.domain.bibliotheca;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

import com.github.dkurata38.liblio.domain.bibliography.BibliographyId;
import com.github.dkurata38.liblio.domain.library.LibraryId;

@EqualsAndHashCode(of = {"id"})
@ToString
public class Bibliotheca {
    @Getter
    private final BibliothecaId id;
    @Getter
    private final LibraryId libraryId;
    @Getter
    private final BibliographyId bibliographyId;

    public Bibliotheca(@NonNull BibliothecaId id, @NonNull LibraryId libraryId, @NonNull BibliographyId bibliographyId) {
        this.id = id;
        this.libraryId = libraryId;
        this.bibliographyId = bibliographyId;
    }
}
