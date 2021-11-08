package com.example.question;

import java.util.Objects;

public class Ordinal implements Comparable<Ordinal> {

    private final int number;

    Ordinal(int number) {
        this.number = number;
    }

    @Override
    public int compareTo(Ordinal other) {
        return Integer.compare(number, other.number);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ordinal ordinal = (Ordinal) o;
        return number == ordinal.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
