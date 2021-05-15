package com.github.dkurata38.liblio.domain.librarian

import com.github.dkurata38.liblio.domain.library.LibraryId

open class Librarian(
    val librarianId: LibrarianId,
    val libraryId: LibraryId,
    val username: Username,
    val password: Password
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Librarian

        if (librarianId != other.librarianId) return false

        return true
    }

    override fun hashCode(): Int {
        return librarianId.hashCode()
    }

    override fun toString(): String {
        return "Librarian(librarianId=$librarianId, libraryId=$libraryId, username=$username, password=$password)"
    }
}
