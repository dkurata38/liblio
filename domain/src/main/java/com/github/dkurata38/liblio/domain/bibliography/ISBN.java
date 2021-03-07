package com.github.dkurata38.liblio.domain.bibliography;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

@EqualsAndHashCode(of = {"value"})
@ToString
public class ISBN {
	private static final String isbnPattern = "^[0-9\\-]{17}$";
	@Getter
	private final String value;

	public ISBN(@NonNull String value) {
		if (!value.matches(isbnPattern)) {
			throw new IllegalArgumentException("invalid isbn13 format");
		}
		this.value = value;
	}
}
