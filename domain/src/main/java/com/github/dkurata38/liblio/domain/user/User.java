package com.github.dkurata38.liblio.domain.user;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@RequiredArgsConstructor
@EqualsAndHashCode(of = {"userId"})
@ToString
public class User {
	@Getter
	private final UserId userId;
	@Getter
	private final Username username;
	@Getter
	private final Password password;
	@Getter
	private final MailAddress mailAddress;
}
