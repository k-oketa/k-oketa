package com.example.question;

public record Option(int ordinal) implements Comparable<Option> {

    @Override
    public int compareTo(Option other) {
        return Integer.compare(ordinal, other.ordinal);
    }
}
