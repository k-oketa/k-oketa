package com.example.answer;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class SingleChoiceAndDescriptionAnswer extends Answer<SingleChoiceAndDescription> {
    SingleChoiceAndDescriptionAnswer(SingleChoiceAndDescription content) {
        super(content);
    }
}
