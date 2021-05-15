package com.github.dkurata38.liblio.infrastructure.librarian

import com.github.dkurata38.liblio.domain.librarian.*
import com.github.dkurata38.liblio.domain.library.LibraryId
import org.springframework.stereotype.Repository

@Repository
class LibrarianRepositoryImpl(private val librarianRecordMapper: LibrarianRecordMapper): LibrarianRepository {
    override fun findByUsername(username: Username): Librarian? {
        val librarianRecord = librarianRecordMapper.selectByUsername(username.value)
        return if (librarianRecord == null) {
            null
        } else {
            Librarian(
                LibrarianId(librarianRecord.librarianId!!),
                LibraryId(librarianRecord.libraryId!!),
                Username(librarianRecord.username!!),
                Password(librarianRecord.password!!),
            )
        }
    }
}
