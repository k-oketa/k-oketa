package com.example.question;

public class Question implements Comparable<Question> {

    int ordinal;

    Question(int ordinal) {
        this.ordinal = ordinal;
    }

    @Override
    public int compareTo(Question o) {
        return 0;
    }
}
