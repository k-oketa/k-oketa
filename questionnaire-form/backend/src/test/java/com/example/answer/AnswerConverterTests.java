package com.example.answer;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AnswerConverterTests {

    @Test
    void testSingleChoiceAnswerToJsonConversion() throws JsonProcessingException {
        var answer = new SingleChoiceAnswer(0);
        var answerConverter = new AnswerConverter();
        var json = answerConverter.convertToJson(answer);
        assertEquals("{\"@type\":\"SingleChoiceAnswer\",\"content\":0}", json);
    }

    @Test
    void testMultipleChoiceAnswerToJsonConversion() throws JsonProcessingException {
        var answer = new MultipleChoiceAnswer(Arrays.asList(0, 1, 2));
        var answerConverter = new AnswerConverter();
        var json = answerConverter.convertToJson(answer);
        assertEquals("{\"@type\":\"MultipleChoiceAnswer\",\"content\":[0,1,2]}", json);
    }

    @Test
    void testDescriptionAnswerToJsonConversion() throws JsonProcessingException {
        var answer = new DescriptionAnswer("It was written");
        var answerConverter = new AnswerConverter();
        var json = answerConverter.convertToJson(answer);
        assertEquals("{\"@type\":\"DescriptionAnswer\",\"content\":\"It was written\"}", json);
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
        var expected = "{\"@type\":\"SingleChoiceAndDescriptionAnswer\",\"content\":" +
                "{\"singleChoiceAnswer\":{\"@type\":\"SingleChoiceAnswer\",\"content\":0}," +
                "\"descriptionAnswer\":{\"@type\":\"DescriptionAnswer\",\"content\":\"It was written\"}}}";
        assertEquals(expected, json);
    }

    @Test
    void testJsonToSingleChoiceAnswerConversion() throws JsonProcessingException {
        var json = "{\"@type\":\"SingleChoiceAnswer\",\"content\":0}";
        var answerConverter = new AnswerConverter();
        var answer = answerConverter.convertToAnswer(json);
        assertEquals(new SingleChoiceAnswer(0), answer);
    }

    @Test
    void testJsonToMultipleChoiceAnswerConversion() throws JsonProcessingException {
        var json = "{\"@type\":\"MultipleChoiceAnswer\",\"content\":[0,1,2]}";
        var answerConverter = new AnswerConverter();
        var answer = answerConverter.convertToAnswer(json);
        assertEquals(new MultipleChoiceAnswer(Arrays.asList(0, 1, 2)), answer);
    }

    @Test
    void testJsonToDescriptionChoiceAnswerConversion() throws  JsonProcessingException {
        var json = "{\"@type\":\"DescriptionAnswer\",\"content\":\"It was written\"}";
        var answerConverter = new AnswerConverter();
        var answer = answerConverter.convertToAnswer(json);
        assertEquals(new DescriptionAnswer("It was written"), answer);
    }
}
