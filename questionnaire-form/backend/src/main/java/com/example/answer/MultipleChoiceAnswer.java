package com.example.answer;

import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
public class MultipleChoiceAnswer extends Answer<List<Integer>> {
    MultipleChoiceAnswer(List<Integer> content) {
        super(content);
    }
}
