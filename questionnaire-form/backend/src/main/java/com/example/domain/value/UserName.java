package com.example.domain.value;

import com.example.exception.user.ShortageUserNameException;
import lombok.Value;

@Value
public class UserName {

    String value;

    UserName(String value) {
        if (value == null) throw new IllegalArgumentException();
        if (value.length() < 5) throw new ShortageUserNameException();
        this.value = value;
    }
}
