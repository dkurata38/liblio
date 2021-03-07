package com.github.dkurata38.liblio.domain.bibliography;

public interface BibliographyRepository {
	Iterable<Bibliography> findAll();
}
