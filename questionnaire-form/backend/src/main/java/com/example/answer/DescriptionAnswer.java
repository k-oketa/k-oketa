package com.example.answer;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class DescriptionAnswer extends Answer<String> {
    public DescriptionAnswer(String content) {
        super(content);
    }
}
