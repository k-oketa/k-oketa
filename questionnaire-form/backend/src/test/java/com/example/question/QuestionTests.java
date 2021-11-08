package com.example.question;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

public class QuestionTests {

    @Test
    void testQuestionComparisonByOrdinal() {
        var one = new Question(1);
        var two = new Question(2);
        assertEquals(one.compareTo(two), -1);
        assertEquals(two.compareTo(one), 1);
    }

    @Test
    void testSortQuestions() {
        var tests = Arrays.asList(
                new Question(1),
                new Question(3),
                new Question(4),
                new Question(2));
        var expected = Arrays.asList(
                new Question(1),
                new Question(2),
                new Question(3),
                new Question(4));
        Collections.sort(tests);
        assertIterableEquals(expected, tests);
    }
}
