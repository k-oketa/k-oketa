package com.example;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SingleChoiceQuestion extends Question {

    public SingleChoiceQuestion() {
        super();
        this.body = "singleChoice";
    }

    public long getId() {
        return super.getId();
    }

    public String getBody() {
        return super.getBody();
    }
}
