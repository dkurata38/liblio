package com.github.dkurata38.liblio.html_presentation.library;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.github.dkurata38.liblio.domain.library.Library;
import com.github.dkurata38.liblio.domain.library.LibraryRepository;

@Controller
@RequestMapping("library")
public class LibraryController {

	private final LibraryRepository libraryRepository;

	@GetMapping
	public String list(Model model) {
		Iterable<Library> libraries = libraryRepository.findAll();
		model.addAttribute("libraries", libraries);
		return "library/list";
	}

	public LibraryController(LibraryRepository libraryRepository) {
		this.libraryRepository = libraryRepository;
	}
}
