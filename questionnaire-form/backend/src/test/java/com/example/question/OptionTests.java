package com.example.question;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

public class OptionTests {

    @Test
    void testOptionComparisonByOrdinal() {
        var one = new Option(1);
        var two = new Option(2);
        assertEquals(one.compareTo(two), -1);
        assertEquals(two.compareTo(one), 1);
    }

    @Test
    void testSortOptions() {
        var tests = Arrays.asList(
                new Option(1),
                new Option(3),
                new Option(4),
                new Option(2));
        var expected = Arrays.asList(
                new Option(1),
                new Option(2),
                new Option(3),
                new Option(4));
        Collections.sort(tests);
        assertIterableEquals(expected, tests);
    }
}
