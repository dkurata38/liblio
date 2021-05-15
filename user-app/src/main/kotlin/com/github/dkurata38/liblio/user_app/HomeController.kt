package com.github.dkurata38.liblio.user_app

import com.github.dkurata38.liblio.user_app.security.LiblioUser
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class HomeController {
    @GetMapping
    fun index(@AuthenticationPrincipal liblioUser: LiblioUser?): String {
        return if (liblioUser == null) {
            "index_unauthenticated"
        } else "index"
    }
}
