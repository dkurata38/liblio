package com.github.dkurata38.liblio.librarian_app.bibliotheca

import com.github.dkurata38.liblio.librarian_app.security.LibrarianUser
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class BibliothecaListController {
    @GetMapping("bibliotheca/bibliotheca-list")
    fun list(@AuthenticationPrincipal librarianUser: LibrarianUser): String {
        return "bibliotheca/bibliothecaList"
    }
}
