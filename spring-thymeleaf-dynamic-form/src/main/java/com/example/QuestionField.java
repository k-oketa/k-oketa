package com.example;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
public class QuestionField {

    private QuestionType questionType;
    private String body;
    private List<OptionField> optionFields;

    public QuestionField() {
        this.questionType = QuestionType.INITIALIZE;
        this.body = "";
        this.optionFields = new ArrayList<>();
    }

    public void addOptionField() {
        this.optionFields.add(new OptionField());
    }
}
