package com.github.dkurata38.liblio.html_presentation.library;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.github.dkurata38.liblio.application.bibliotheca.BibliothecaService;
import com.github.dkurata38.liblio.application.library.LibraryService;
import com.github.dkurata38.liblio.domain.bibliography.Bibliography;
import com.github.dkurata38.liblio.domain.library.Library;
import com.github.dkurata38.liblio.domain.library.LibraryId;
import com.github.dkurata38.liblio.domain.library.LibraryRepository;

@Controller
@RequestMapping("library")
public class LibraryController {

	private final LibraryService libraryService;
	private final BibliothecaService bibliothecaService;

	public LibraryController(LibraryService libraryService, BibliothecaService bibliothecaService) {
		this.libraryService = libraryService;
		this.bibliothecaService = bibliothecaService;
	}

	@GetMapping
	public String list(Model model) {
		Iterable<Library> libraries = libraryService.getList();
		model.addAttribute("libraries", libraries);
		return "library/list";
	}

	@GetMapping("{libraryId}")
	public String get(@PathVariable(value = "libraryId") LibraryId libraryId, Model model) {
		Library library = libraryService.getById(libraryId)
				.orElseThrow();
		Iterable<Bibliography> bibliographies = bibliothecaService.getByLibraryId(libraryId);
		model.addAttribute("library", library);
		model.addAttribute("bibliographies", bibliographies);
		return "library/detail";
	}
}
