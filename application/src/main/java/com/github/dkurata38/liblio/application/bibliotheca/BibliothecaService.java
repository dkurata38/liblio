package com.github.dkurata38.liblio.application.bibliotheca;

import lombok.NonNull;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;
import org.springframework.stereotype.Service;
import com.github.dkurata38.liblio.domain.bibliography.Bibliography;
import com.github.dkurata38.liblio.domain.bibliography.BibliographyId;
import com.github.dkurata38.liblio.domain.bibliography.BibliographyRepository;
import com.github.dkurata38.liblio.domain.bibliotheca.Bibliotheca;
import com.github.dkurata38.liblio.domain.bibliotheca.BibliothecaRepository;
import com.github.dkurata38.liblio.domain.library.LibraryId;

@Service
public class BibliothecaService {
	private final BibliothecaRepository bibliothecaRepository;
	private final BibliographyRepository bibliographyRepository;

	public BibliothecaService(BibliothecaRepository bibliothecaRepository, BibliographyRepository bibliographyRepository) {
		this.bibliothecaRepository = bibliothecaRepository;
		this.bibliographyRepository = bibliographyRepository;
	}

	public Iterable<Bibliography> getByLibraryId(@NonNull LibraryId libraryId) {
		Iterable<Bibliotheca> bibliotheca = bibliothecaRepository.findByLibraryId(libraryId);
		List<BibliographyId> bibliographyIds = StreamSupport.stream(bibliotheca.spliterator(), false)
				.map(Bibliotheca::getBibliographyId)
				.collect(Collectors.toList());
		Iterable<Bibliography> bibliographies = bibliographyRepository.findAll();
		return StreamSupport.stream(bibliographies.spliterator(), true)
				.filter(bibliography -> bibliographyIds.contains(bibliography.getId()))
				.collect(Collectors.toList());
	}
}
