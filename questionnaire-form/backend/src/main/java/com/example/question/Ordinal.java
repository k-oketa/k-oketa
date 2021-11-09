package com.example.question;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class Ordinal implements Comparable<Ordinal> {

    private final int number;

    Ordinal(int number) {
        this.number = number;
    }

    @Override
    public int compareTo(Ordinal other) {
        return Integer.compare(number, other.number);
    }
}
