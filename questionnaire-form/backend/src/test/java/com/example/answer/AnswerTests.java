package com.example.answer;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AnswerTests {

    @Test
    void testSingleChoiceAnswerToJsonConversion() throws JsonProcessingException {
        var answer = new SingleChoiceAnswer("singleChoice", 0);
        var answerConverter = new AnswerConverter();
        var json = answerConverter.convertToJson(answer);
        assertEquals("{\"type\":\"singleChoice\",\"content\":0}", json);
    }

    @Test
    void testMultipleChoiceAnswerToJsonConversion() throws JsonProcessingException {
        var answer = new MultipleChoiceAnswer("multipleChoice", Arrays.asList(0, 1, 2));
        var answerConverter = new AnswerConverter();
        var json = answerConverter.convertToJson(answer);
        assertEquals("{\"type\":\"multipleChoice\",\"content\":[0,1,2]}", json);
    }
}
