package com.github.dkurata38.liblio.domain.library;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

@EqualsAndHashCode(of = {"value"})
@ToString
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
