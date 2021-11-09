package com.example.question;

import lombok.Getter;

public class Question extends Ordinal {

    @Getter
    private final String body;
    String questionType;

    private Question(int number, String body) {
        super(number);
        this.body = body;
    }
}
