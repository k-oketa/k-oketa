package com.example;

import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;
import java.util.List;

@Getter
@Setter
public class QuestionField {

    private String body;
    private List<OptionField> optionFields;

    public QuestionField() {
        this.body = "";
        this.optionFields = Arrays.asList(new OptionField(), new OptionField());
    }

    public void addOptionField() {
        this.optionFields.add(new OptionField());
    }
}
