package com.example.domain.value;

import lombok.NonNull;
import lombok.Value;

@Value
public class UserName {

    @NonNull
    String value;

    public UserName(String value) {
        if (value.isBlank()) throw new IllegalArgumentException("valueが空文字です");
        if (value.length() < 3) throw new IllegalArgumentException("ユーザ名は3文字以上です");
        if (value.length() > 20) throw new IllegalArgumentException("ユーザ名は20文字以下です");
        this.value = value;
    }
}
