package com.example.exception.user;

public class IncludingUnavailableCharacterUserNameException extends IllegalArgumentException {

    public IncludingUnavailableCharacterUserNameException() {
        super("ユーザ名に使用できない文字が含まれます。ユーザ名には、半角英数字と-、_のみ使用できます。");
    }
}
