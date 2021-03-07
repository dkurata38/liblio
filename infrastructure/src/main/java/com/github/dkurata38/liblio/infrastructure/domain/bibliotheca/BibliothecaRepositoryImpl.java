package com.github.dkurata38.liblio.infrastructure.domain.bibliotheca;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Repository;
import com.github.dkurata38.liblio.domain.bibliography.BibliographyId;
import com.github.dkurata38.liblio.domain.bibliotheca.Bibliotheca;
import com.github.dkurata38.liblio.domain.bibliotheca.BibliothecaId;
import com.github.dkurata38.liblio.domain.bibliotheca.BibliothecaRepository;
import com.github.dkurata38.liblio.domain.library.LibraryId;

@Repository
public class BibliothecaRepositoryImpl implements BibliothecaRepository {
	List<Bibliotheca> bibliothecaList = List.of(
			new Bibliotheca(new BibliothecaId(""), new LibraryId("abc"), new BibliographyId("aaa")),
			new Bibliotheca(new BibliothecaId(""), new LibraryId("def"), new BibliographyId("bbb"))
			);
	@Override
	public Iterable<Bibliotheca> findByLibraryId(LibraryId libraryId) {
		return bibliothecaList.stream()
				.filter(bibliotheca -> bibliotheca.getLibraryId().equals(libraryId))
				.collect(Collectors.toList());
	}
}
