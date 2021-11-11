package com.example.answer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AnswerTests {

    @Test
    void testAnswerToJsonConversion() {
        var answer = new Answer();
        var answerConverter = new AnswerConverter();
        var json = answerConverter.convertToJson(answer);
        assertEquals("{}", json);
    }
}
