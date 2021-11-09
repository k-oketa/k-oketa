package com.example.question;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

public class QuestionTests {

    @Test
    void testSortQuestion() {
        var questions = Arrays.asList(
                new SingleChoiceQuestion(1),
                new MultipleChoiceQuestion(4),
                new DescriptionQuestion(2),
                new SingleChoiceDescriptionQuestion(3));
        var expected = Arrays.asList(
                new SingleChoiceQuestion(1),
                new DescriptionQuestion(2),
                new SingleChoiceDescriptionQuestion(3),
                new MultipleChoiceQuestion(4));
        Collections.sort(questions);
        assertIterableEquals(expected, questions);
    }

}
