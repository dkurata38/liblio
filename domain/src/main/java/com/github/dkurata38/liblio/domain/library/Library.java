package com.github.dkurata38.liblio.domain.library;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode(of = {"id"})
public class Library {
	@Getter
	private final LibraryId id;
	@Getter
	private final LibraryName name;

	public Library(LibraryId id, LibraryName name) {
		this.id = id;
		this.name = name;
	}
}