package com.example;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class SurveyField {
    private List<QuestionField> questionFields;

    public SurveyField() {
        this.questionFields = new ArrayList<>();
    }

    public void addQuestion() {
        this.questionFields.add(new QuestionField());
    }
}
