package com.example.question;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

public class OptionTests {

    @Test
    void testSortOption() {
        var actual = Arrays.asList(
                new Option(1),
                new Option(3),
                new Option(4),
                new Option(2));
        var expected = Arrays.asList(
                new Option(1),
                new Option(2),
                new Option(3),
                new Option(4));
        assertIterableEquals(expected, actual);
    }
}
