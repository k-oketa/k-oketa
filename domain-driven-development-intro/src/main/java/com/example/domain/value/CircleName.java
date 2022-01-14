package com.example.domain.value;

import lombok.NonNull;
import lombok.Value;

@Value
public class CircleName {

    @NonNull
    String value;

    public CircleName(String value) {
        if (value.length() < 3) throw new IllegalArgumentException();
        if (value.length() > 20) throw new IllegalArgumentException();
        this.value = value;
    }
}
