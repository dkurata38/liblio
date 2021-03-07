package com.github.dkurata38.liblio.domain.bibliography;

import lombok.Getter;

public enum Language {
	JAPANESE("ja");
	@Getter
	private final String languageCode;
	Language(String languageCode) {
		this.languageCode = languageCode;
	}
}
