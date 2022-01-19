package com.example.domain.value;

import com.example.exception.user.IncludingUnavailableCharacterUserNameException;
import com.example.exception.user.LongageUserNameException;
import com.example.exception.user.ShortageUserNameException;
import lombok.Value;

/**
 * ユーザ名の値オブジェクト
 *
 * 半角英数字と「-」「_」のみ利用可能
 */
@Value
public class UserName {

    String value;

    UserName(String value) {
        if (value == null) throw new IllegalArgumentException();
        if (value.length() < 5) throw new ShortageUserNameException();
        if (value.length() > 64) throw new LongageUserNameException();
        if (availableOnlyRuledCharacter(value)) throw new IncludingUnavailableCharacterUserNameException();
        this.value = value;
    }

    boolean availableOnlyRuledCharacter(String value) {
        return value.matches("^.*[^[a-z][A-Z][0-9]-_].*$");
    }
}
