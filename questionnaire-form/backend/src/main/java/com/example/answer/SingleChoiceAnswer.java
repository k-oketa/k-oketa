package com.example.answer;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class SingleChoiceAnswer extends Answer<Integer> {
    public SingleChoiceAnswer(Integer content) {
        super(content);
    }
}
