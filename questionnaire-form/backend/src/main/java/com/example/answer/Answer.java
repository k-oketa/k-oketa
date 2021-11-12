package com.example.answer;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;

@Getter
@JsonTypeInfo(use=JsonTypeInfo.Id.NAME)
public abstract class Answer<T> {

    Answer(T content) {
        this.content = content;
    }

    T content;
}
