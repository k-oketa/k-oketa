package com.example.question;

public class Question implements Comparable<Question> {

    int ordinal;

    Question(int ordinal) {
        this.ordinal = ordinal;
    }

    @Override
    public int compareTo(Question o) {
        if (ordinal < o.ordinal) {
            return -1;
        } else if (ordinal > o.ordinal) {
            return 1;
        } else {
            return 0;
        }
    }
}
