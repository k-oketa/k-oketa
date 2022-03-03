package com.example;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
public class SurveyField {
    private List<QuestionField> questionFields;

    public SurveyField() {
        this.questionFields = new ArrayList<>();
    }

    public void addQuestion() {
        var questionField = new QuestionField();
        questionField.setQuestionType(QuestionType.SINGLE_CHOICE);
        this.questionFields.add(questionField);
    }

    public void addDescriptionQuestion() {
        var questionField = new QuestionField();
        questionField.setQuestionType(QuestionType.DESCRIPTION);
        this.questionFields.add(questionField);
    }

}
