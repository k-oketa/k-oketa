package com.example.question;

public class Option implements Comparable<Option> {

    Ordinal ordinal;

    Option(int number) {
        this.ordinal = new Ordinal(number);
    }

    @Override
    public int compareTo(Option o) {
        return ordinal.compareTo(o.ordinal);
    }

    @Override
    public boolean equals(Object object) {
        var other = (Option) object;
        return compareTo(other) == 0;
    }
}
