package com.example.answer;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AnswerTests {

    @Test
    void testSingleChoiceAnswerToJsonConversion() throws JsonProcessingException {
        var answer = new SingleChoiceAnswer("singleChoice", 0);
        var answerConverter = new AnswerConverter();
        var json = answerConverter.convertToJson(answer);
        assertEquals("{\"type\":\"singleChoice\",\"content\":0}", json);
    }
}
