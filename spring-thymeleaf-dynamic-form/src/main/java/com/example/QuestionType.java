package com.example;

public enum QuestionType {
    INITIALIZE,
    SINGLE_CHOICE,
    MULTIPLE_CHOICE,
    DESCRIPTION,
    SINGLE_CHOICE_AND_DESCRIPTION;

    public boolean isSingleChoice() {
        return this == SINGLE_CHOICE;
    }

    public boolean isDescription() {
        return this == DESCRIPTION;
    }
}
