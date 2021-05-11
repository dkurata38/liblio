package com.github.dkurata38.liblio.librarian_app.bibliotheca;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import com.github.dkurata38.liblio.librarian_app.security.LibrarianUser;

@Controller
public class BibliothecaListController {
    @GetMapping("bibliotheca/bibliotheca-list")
    public String list(@AuthenticationPrincipal LibrarianUser librarianUser) {
        return "bibliotheca/bibliothecaList";
    }
}
