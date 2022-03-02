package com.example;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Survey implements Serializable {
    private List<? super Question> questions;

    public Survey() {
        this.questions = new ArrayList<>();
    }

    public void addQuestion() {
        questions.add(new SingleChoiceQuestion());
    }

    public void addDescriptionField() {
        questions.add(new DescriptionQuestion());
    }
}
