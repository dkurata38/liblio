package com.github.dkurata38.liblio.librarian_app

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class HomeController {
    @GetMapping
    fun index(): String? {
        return "index"
    }
}
