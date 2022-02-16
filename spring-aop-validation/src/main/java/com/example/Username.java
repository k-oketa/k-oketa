package com.example;

import lombok.Value;

@Value
public class Username {

    String value;

    public Username(String value) {
        if (value.isBlank()) throw new IllegalArgumentException("ユーザ名は空白不可");
        this.value = value;
    }
}
