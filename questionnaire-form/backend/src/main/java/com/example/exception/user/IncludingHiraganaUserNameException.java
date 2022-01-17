package com.example.exception.user;

public class IncludingHiraganaUserNameException extends IllegalArgumentException {

    public IncludingHiraganaUserNameException() {
        super("ユーザ名にひらがなが含まれます。ユーザ名にひらがなは使用できません。");
    }
}
