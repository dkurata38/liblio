package com.github.dkurata38.liblio.domain.bibliotheca;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

@EqualsAndHashCode(of = {"value"})
@ToString
public class BibliothecaId {
	@Getter
	private final String value;

	public BibliothecaId(@NonNull String value) {
		this.value = value;
	}
}
