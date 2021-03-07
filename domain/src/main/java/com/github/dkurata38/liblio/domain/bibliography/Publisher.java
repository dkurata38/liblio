package com.github.dkurata38.liblio.domain.bibliography;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

@EqualsAndHashCode(of = {"value"})
@ToString
public class Publisher {
	@Getter
	private final String value;

	public Publisher(@NonNull String value) {
		this.value = value;
	}
}