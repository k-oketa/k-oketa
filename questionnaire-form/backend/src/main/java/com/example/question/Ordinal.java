package com.example.question;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
class Ordinal implements Comparable<Ordinal> {

    private final int number;

    protected Ordinal(int number) {
        this.number = number;
    }

    @Override
    public int compareTo(Ordinal other) {
        return Integer.compare(number, other.number);
    }
}
