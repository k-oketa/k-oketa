package com.example.answer;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class SingleChoiceAndDescriptionAnswer extends Answer<SingleChoiceAndDescription> {
    SingleChoiceAndDescriptionAnswer(SingleChoiceAndDescription content) {
        super(content);
    }
}
