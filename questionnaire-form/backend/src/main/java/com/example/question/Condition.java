package com.example.question;

public class Condition {

    int targetQuestionId;
    int triggerOptionId;

    Condition(int targetQuestionId, int triggerOptionId) {
        this.targetQuestionId = targetQuestionId;
        this.triggerOptionId = triggerOptionId;
    }

    @Override
    public boolean equals(Object obj) {
        var other = (Condition) obj;
        return targetQuestionId == other.targetQuestionId && triggerOptionId == other.triggerOptionId;
    }
}
