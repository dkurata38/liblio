package com.github.dkurata38.liblio.domain.librarian

interface LibrarianRepository {
    fun findByUsername(username: Username): Librarian?;
}
