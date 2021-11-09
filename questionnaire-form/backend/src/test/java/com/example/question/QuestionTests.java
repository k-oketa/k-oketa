package com.example.question;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

public class QuestionTests {

    @Test
    void testSortQuestion() {
        var questions = Arrays.asList(
                new SingleChoiceQuestion(1),
                new MultipleChoiceQuestion(4),
                new DescriptionQuestion(2),
                new SingleChoiceDescriptionQuestion(2));
        Collections.sort(questions);
    }

}
