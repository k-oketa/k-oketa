package com.example.answer;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AnswerTests {

    @Test
    void testAnswerToJsonConversion() throws JsonProcessingException {
        var answer = new Answer("description", "description");
        var answerConverter = new AnswerConverter();
        var json = answerConverter.convertToJson(answer);
        assertEquals("{\"type\":\"description\",\"content\":\"description\"}", json);
    }
}
