package com.example.answer;

import lombok.Getter;

@Getter
public abstract class Answer<T> {

    Answer(String type, T content) {
        this.type = type;
        this.content = content;
    }

    String type;
    T content;
}
