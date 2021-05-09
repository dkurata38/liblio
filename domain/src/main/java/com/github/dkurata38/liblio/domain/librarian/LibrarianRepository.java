package com.github.dkurata38.liblio.domain.librarian;

import java.util.Optional;

public interface LibrarianRepository {
    Optional<Librarian> findByUsername(Username username);
}
