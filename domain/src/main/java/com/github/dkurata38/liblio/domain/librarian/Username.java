package com.github.dkurata38.liblio.domain.librarian;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

@EqualsAndHashCode
@ToString
public class Username {
	@Getter
	private final String value;

	public Username(@NonNull String value) {
		this.value = value;
	}
}
