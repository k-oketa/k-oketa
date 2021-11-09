package com.example.question;

public class Question implements Comparable<Question> {

    Ordinal ordinal;

    Question(int number) {
        this.ordinal = new Ordinal(number);
    }

    @Override
    public int compareTo(Question o) {
        return ordinal.compareTo(o.ordinal);
    }

    @Override
    public boolean equals(Object o) {
        var other = (Question) o;
        return compareTo(other) == 0;
    }
}
