package com.github.dkurata38.liblio.domain.library

import java.util.*

data class LibraryId(val value: String) {
    companion object {
        @JvmStatic
        fun generate(): LibraryId {
            return LibraryId(UUID.randomUUID().toString())
        }
    }
}
