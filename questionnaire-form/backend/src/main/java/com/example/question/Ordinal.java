package com.example.question;

public record Ordinal(int number) implements Comparable<Ordinal> {

    @Override
    public int compareTo(Ordinal other) {
        return Integer.compare(number, other.number);
    }
}
