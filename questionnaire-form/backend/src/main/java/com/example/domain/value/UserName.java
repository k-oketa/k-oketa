package com.example.domain.value;

import lombok.Value;

@Value
public class UserName {

    String value;

    UserName(String value) {
        if (value == null) throw new IllegalArgumentException();
        this.value = value;
    }
}
