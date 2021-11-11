package com.example.answer;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AnswerTests {

    @Test
    void testSingleChoiceAnswerToJsonConversion() throws JsonProcessingException {
        var answer = new SingleChoiceAnswer(0);
        var answerConverter = new AnswerConverter();
        var json = answerConverter.convertToJson(answer);
        assertEquals("{\"@class\":\"com.example.answer.SingleChoiceAnswer\",\"content\":0}", json);
    }

    @Test
    void testMultipleChoiceAnswerToJsonConversion() throws JsonProcessingException {
        var answer = new MultipleChoiceAnswer(Arrays.asList(0, 1, 2));
        var answerConverter = new AnswerConverter();
        var json = answerConverter.convertToJson(answer);
        assertEquals("{\"@class\":\"com.example.answer.MultipleChoiceAnswer\",\"content\":[0,1,2]}", json);
    }

    @Test
    void testDescriptionAnswerToJsonConversion() throws JsonProcessingException {
        var answer = new DescriptionAnswer("It was written");
        var answerConverter = new AnswerConverter();
        var json = answerConverter.convertToJson(answer);
        assertEquals("{\"@class\":\"com.example.answer.DescriptionAnswer\",\"content\":\"It was written\"}", json);
    }

    @Test
    void testSingleChoiceAndDescriptionAnswerToJsonConversion() throws JsonProcessingException {
        var answer = new SingleChoiceAndDescriptionAnswer(
                new SingleChoiceAndDescription(
                        new SingleChoiceAnswer(0),
                        new DescriptionAnswer("It was written")
                ));
        var answerConverter = new AnswerConverter();
        var json = answerConverter.convertToJson(answer);
        var expected = "{\"@class\":\"com.example.answer.SingleChoiceAndDescriptionAnswer\",\"content\":" +
                "{\"singleChoiceAnswer\":{\"@class\":\"com.example.answer.SingleChoiceAnswer\",\"content\":0}," +
                "\"descriptionAnswer\":{\"@class\":\"com.example.answer.DescriptionAnswer\",\"content\":\"It was written\"}}}";
        assertEquals(expected, json);
    }

    @Test
    void testJsonToSingleChoiceAnswerConversion() throws JsonProcessingException {
        var json = "{\"@class\":\"com.example.answer.SingleChoiceAnswer\",\"content\":0}";
        var answerConverter = new AnswerConverter();
        var answer = answerConverter.convertToAnswer(json, SingleChoiceAnswer.class);
        assertEquals(new SingleChoiceAnswer(0), answer);
    }
}
