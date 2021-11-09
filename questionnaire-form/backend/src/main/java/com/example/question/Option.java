package com.example.question;

import lombok.Getter;

@Getter
public class Option extends Ordinal {

    private final String body;

    public Option(int number, String body) {
        super(number);
        this.body = body;
    }
}
