package com.example.answer;

import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode
public class MultipleChoiceAnswer extends Answer<List<Integer>> {
    MultipleChoiceAnswer(List<Integer> content) {
        super(content);
    }
}
