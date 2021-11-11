package com.example.answer;

import lombok.Getter;

@Getter
public class SingleChoiceAndDescription {

    Answer<Integer> singleChoiceAnswer;
    Answer<String> descriptionAnswer;

    SingleChoiceAndDescription(Answer<Integer> singleChoiceAnswer, Answer<String> descriptionAnswer) {
        this.singleChoiceAnswer = singleChoiceAnswer;
        this.descriptionAnswer = descriptionAnswer;
    }
}
