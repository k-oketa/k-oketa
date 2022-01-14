package com.example.domain.value;

import lombok.NonNull;
import lombok.Value;

@Value
public class CircleId {

    @NonNull
    String value;

    public CircleId(String value) {
        this.value = value;
    }
}
