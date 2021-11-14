package com.example.answer;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@JsonTypeInfo(use=JsonTypeInfo.Id.NAME)
@EqualsAndHashCode
@NoArgsConstructor
abstract class Answer<T> {

    private T content;

    protected Answer(T content) {
        this.content = content;
    }
}
