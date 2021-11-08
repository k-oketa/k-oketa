package com.example.question;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OptionTests {

    @Test
    void testOptionComparisonByOrdinal() {
        var one = new Option(1);
        var two = new Option(2);
        assertEquals(one.compareTo(two), -1);
        assertEquals(two.compareTo(one), 1);
    }
}
