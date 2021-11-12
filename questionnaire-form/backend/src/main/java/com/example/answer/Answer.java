package com.example.answer;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@JsonTypeInfo(use=JsonTypeInfo.Id.NAME)
@EqualsAndHashCode
@NoArgsConstructor
public abstract class Answer<T> {

    T content;

    Answer(T content) {
        this.content = content;
    }
}
