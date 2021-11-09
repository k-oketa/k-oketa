package com.example.question;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

public class OptionTests {

    @Test
    void testSortOption() {
        var actual = Arrays.asList(
                new Option(1, "とても好き"),
                new Option(3, "どちらでもない"),
                new Option(4, "やや嫌い"),
                new Option(2, "やや好き"));
        var expected = Arrays.asList(
                new Option(1, "とても好き"),
                new Option(2, "やや好き"),
                new Option(3, "どちらでもない"),
                new Option(4, "やや嫌い"));
        Collections.sort(actual);
        assertIterableEquals(expected, actual);
    }
}
