package com.example.question;

public class Option implements Comparable<Option> {

    int ordinal;

    Option(int ordinal) {
        this.ordinal = ordinal;
    }

    @Override
    public int compareTo(Option other) {
        if (ordinal < other.ordinal) {
            return -1;
        } else if (ordinal > other.ordinal) {
            return 1;
        } else {
            return 0;
        }
    }
}
