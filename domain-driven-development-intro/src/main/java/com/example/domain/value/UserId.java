package com.example.domain.value;

import lombok.NonNull;
import lombok.Value;

@Value
public class UserId {

    @NonNull
    String value;

    public UserId(String value) {
        if (value.isBlank()) throw new IllegalArgumentException("valueが空文字です");
        this.value = value;
    }


}
