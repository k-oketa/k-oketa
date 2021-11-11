package com.example.answer;

import java.util.List;

public class MultipleChoiceAnswer extends Answer<List<Integer>> {
    MultipleChoiceAnswer(String type, List<Integer> content) {
        super(type, content);
    }
}
