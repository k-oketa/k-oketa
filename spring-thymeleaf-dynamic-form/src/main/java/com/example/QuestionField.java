package com.example;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class QuestionField {

    private String body;
    private int optionCount;
    private List<OptionField> optionFields;

    public QuestionField() {
        this.body = "";
        this.optionCount = 1;
        this.optionFields = new ArrayList<>(optionCount);
    }

    public void addOptionField() {
        this.optionCount += 1;
        this.optionFields = new ArrayList<>(optionCount);
    }
}
