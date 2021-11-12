package com.example.answer;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class SingleChoiceAnswer extends Answer<Integer> {
    SingleChoiceAnswer(Integer content) {
        super(content);
    }
}
