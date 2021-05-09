package com.github.dkurata38.liblio.domain.librarian;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

@EqualsAndHashCode
@ToString
public class LibrarianId {
    @Getter
    private final String value;

    public LibrarianId(@NonNull String value) {
        this.value = value;
    }
}
