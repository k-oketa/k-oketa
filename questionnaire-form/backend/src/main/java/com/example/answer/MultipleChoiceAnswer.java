package com.example.answer;

import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
public class MultipleChoiceAnswer extends Answer<List<Integer>> {
    public MultipleChoiceAnswer(List<Integer> content) {
        super(content);
    }
}
