package com.example.question;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

public class QuestionTests {

    @Test
    void testSortQuestion() {
        var actual = Arrays.asList(
                new Question(1),
                new Question(3),
                new Question(4),
                new Question(2));
        var expected = Arrays.asList(
                new Question(1),
                new Question(2),
                new Question(3),
                new Question(4));
        Collections.sort(actual);
        assertIterableEquals(expected, actual);
    }

}
