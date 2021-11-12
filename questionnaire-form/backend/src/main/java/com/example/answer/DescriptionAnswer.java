package com.example.answer;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class DescriptionAnswer extends Answer<String> {
    DescriptionAnswer(String content) {
        super(content);
    }
}
