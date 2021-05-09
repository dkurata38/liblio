package com.github.dkurata38.liblio.domain.user;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

@EqualsAndHashCode
@ToString
public class Password {
    @Getter
    private final String value;

    public Password(@NonNull String value) {
        this.value = value;
    }
}
