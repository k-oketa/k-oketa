package com.example.question;

public record Question(int ordinal) implements Comparable<Question> {

    @Override
    public int compareTo(Question o) {
        return Integer.compare(ordinal, o.ordinal);
    }
}
