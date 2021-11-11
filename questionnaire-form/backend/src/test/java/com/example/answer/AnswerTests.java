package com.example.answer;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Test;

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

    @Test
    void testDescriptionAnswerToJsonConversion() throws JsonProcessingException {
        var answer = new DescriptionAnswer("description", "It was written");
        var answerConverter = new AnswerConverter();
        var json = answerConverter.convertToJson(answer);
        assertEquals("{\"type\":\"description\",\"content\":\"It was written\"}", json);
    }

    @Test
    void testSingleChoiceAndDescriptionAnswerToJsonConversion() throws JsonProcessingException {
        var answer = new SingleChoiceAndDescriptionAnswer(
                "singleChoiceAndDescription",
                new SingleChoiceAndDescription(
                        new SingleChoiceAnswer("singleChoice", 0),
                        new DescriptionAnswer("description", "It was written")
                ));
        var answerConverter = new AnswerConverter();
        var json = answerConverter.convertToJson(answer);
        var expected = "{\"type\":\"singleChoiceAndDescription\",\"content\":" +
                "{\"singleChoiceAnswer\":{\"type\":\"singleChoice\",\"content\":0}," +
                "\"descriptionAnswer\":{\"type\":\"description\",\"content\":\"It was written\"}}}";
        assertEquals(expected, json);
    }
}
