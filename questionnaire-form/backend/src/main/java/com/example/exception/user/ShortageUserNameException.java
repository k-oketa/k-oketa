package com.example.exception.user;

public class ShortageUserNameException extends IllegalArgumentException {

    public ShortageUserNameException() {
        super("ユーザ名が短すぎます。ユーザ名は5文字以上である必要があります。");
    }
}
