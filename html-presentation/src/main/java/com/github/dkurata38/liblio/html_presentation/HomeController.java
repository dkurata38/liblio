package com.github.dkurata38.liblio.html_presentation;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import com.github.dkurata38.liblio.html_presentation.security.LiblioUser;

@Controller
public class HomeController {
	@GetMapping
	public String index(
			@AuthenticationPrincipal LiblioUser liblioUser
			) {
		if (liblioUser == null) {
			return "index_unauthenticated";
		}
		return "index";
	}
}
