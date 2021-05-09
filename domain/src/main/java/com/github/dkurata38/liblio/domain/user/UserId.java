package com.github.dkurata38.liblio.domain.user;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

import java.util.UUID;

@EqualsAndHashCode
@ToString
public class UserId {
    @Getter
    private final String value;

    public UserId(@NonNull String value) {
        this.value = value;
    }

    public static UserId generate() {
        return new UserId(UUID.randomUUID().toString());
    }
}
