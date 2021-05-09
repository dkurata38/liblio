package com.github.dkurata38.liblio.domain.bibliography;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

@EqualsAndHashCode(of = {"value"})
@ToString
public class Title {
    @Getter
    private final String value;

    public Title(@NonNull String value) {
        this.value = value;
    }
}
