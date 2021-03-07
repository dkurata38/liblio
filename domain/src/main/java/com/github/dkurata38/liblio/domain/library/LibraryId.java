package com.github.dkurata38.liblio.domain.library;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode(of = {"value"})
public class LibraryId {
	@Getter
	private final String value;

	public LibraryId(String value) {
		this.value = value;
	}
}
