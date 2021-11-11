package com.example.answer;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;

@Getter
@JsonTypeInfo(use=JsonTypeInfo.Id.CLASS)
public abstract class Answer<T> {

    Answer(T content) {
        this.content = content;
    }

    T content;
}
