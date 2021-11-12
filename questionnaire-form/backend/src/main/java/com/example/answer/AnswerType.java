package com.example.answer;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@AllArgsConstructor
@Getter
public enum AnswerType {

    SINGLE_CHOICE("SingleChoiceAnswer"),
    MULTIPLE_CHOICE("MultipleChoiceAnswer"),
    DESCRIPTION("DescriptionAnswer"),
    SINGLE_CHOICE_AND_DESCRIPTION("SingleChoiceAndDescriptionAnswer"),
    EMPTY("EmptyAnswer");

    private final String name;

    public static AnswerType lookup(String name) {
        return Arrays.stream(AnswerType.values())
                .filter(value -> value.getName().equals(name))
                .findFirst()
                .orElseThrow(() -> new EnumConstantNotPresentException(AnswerType.class, name));
    }

}
