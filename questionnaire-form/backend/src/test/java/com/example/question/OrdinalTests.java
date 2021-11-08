package com.example.question;

import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.Or;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

public class OrdinalTests {

    @Test
    void testOrdinalComparison() {
        var one = new Ordinal(1);
        var two = new Ordinal(2);
        assertEquals(one.compareTo(two), -1);
        assertEquals(two.compareTo(one), 1);
    }

    @Test
    void testSortOrdinal() {
        var tests = Arrays.asList(
                new Ordinal(1),
                new Ordinal(3),
                new Ordinal(4),
                new Ordinal(2));
        var expected = Arrays.asList(
                new Ordinal(1),
                new Ordinal(2),
                new Ordinal(3),
                new Ordinal(4));
        Collections.sort(tests);
        assertIterableEquals(expected, tests);
    }
}
