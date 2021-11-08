package com.example.question;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class QuestionTests {

    @Test
    void testQuestionComparisonByOrdinal() {
        var one = new Question(1);
        var two = new Question(2);
        assertEquals(one.compareTo(two), -1);
        assertEquals(two.compareTo(one), 1);
    }
}
