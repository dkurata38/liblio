package com.github.dkurata38.liblio.domain.library;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;

@EqualsAndHashCode(of = {"value"})
public class LibraryName {
	@Getter
	private final String value;

	public LibraryName(@NonNull String value) {
		if (value.isEmpty()) {
			throw new IllegalArgumentException();
		}
		this.value = value;
	}
}
