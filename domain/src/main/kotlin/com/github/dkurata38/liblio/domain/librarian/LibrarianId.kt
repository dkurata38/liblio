package com.github.dkurata38.liblio.domain.librarian

import java.util.*

data class LibrarianId(val value: String) {
    companion object {
        fun generate(): LibrarianId {
            return LibrarianId(UUID.randomUUID().toString())
        }
    }
}
