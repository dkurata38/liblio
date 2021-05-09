package com.github.dkurata38.liblio.domain.librarian;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

import com.github.dkurata38.liblio.domain.library.LibraryId;

@EqualsAndHashCode(of = {"libraryId"})
@ToString
public class Librarian {
    @Getter
    private final LibrarianId librarianId;
    @Getter
    private final LibraryId libraryId;
    @Getter
    private final Username username;
    @Getter
    private final Password password;

    public Librarian(@NonNull LibrarianId librarianId, @NonNull LibraryId libraryId,
                     @NonNull Username username, @NonNull Password password) {
        this.librarianId = librarianId;
        this.libraryId = libraryId;
        this.username = username;
        this.password = password;
    }
}
