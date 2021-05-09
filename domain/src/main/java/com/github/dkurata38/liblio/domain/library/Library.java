package com.github.dkurata38.liblio.domain.library;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@EqualsAndHashCode(of = {"id"})
@ToString
public class Library {
    @Getter
    private final LibraryId id;
    @Getter
    private final LibraryName name;

    public Library(LibraryId id, LibraryName name) {
        this.id = id;
        this.name = name;
    }
}
