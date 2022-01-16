package com.example.answer;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AnswerConverterTests {

    @Nested
    @DisplayName("Answerを継承したクラスはJsonに変換できる")
    class ConvertableFromAnswerToJson {
        @Test
        @DisplayName("SingleChoiceAnswerクラスをJsonに変換する")
        void testSingleChoiceAnswerToJsonConversion() throws JsonProcessingException {
            var answer = new SingleChoiceAnswer(0);
            var answerConverter = new AnswerConverter();
            var json = answerConverter.convertToJson(answer);
            assertEquals("{\"@type\":\"SingleChoiceAnswer\",\"content\":0}", json);
        }

        @Test
        @DisplayName("MultipleChoiceAnswerクラスをJsonに変換する")
        void testMultipleChoiceAnswerToJsonConversion() throws JsonProcessingException {
            var answer = new MultipleChoiceAnswer(Arrays.asList(0, 1, 2));
            var answerConverter = new AnswerConverter();
            var json = answerConverter.convertToJson(answer);
            assertEquals("{\"@type\":\"MultipleChoiceAnswer\",\"content\":[0,1,2]}", json);
        }

        @Test
        @DisplayName("DescriptionAnswerクラスをJsonに変換する")
        void testDescriptionAnswerToJsonConversion() throws JsonProcessingException {
            var answer = new DescriptionAnswer("It was written");
            var answerConverter = new AnswerConverter();
            var json = answerConverter.convertToJson(answer);
            assertEquals("{\"@type\":\"DescriptionAnswer\",\"content\":\"It was written\"}", json);
        }

        @Test
        @DisplayName("SingleChoiceAndDescriptionAnswerクラスをJsonに変換する")
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
        @DisplayName("EmptyAnswerクラスをJsonに変換する")
        void testEmptyAnswerToJsonConversion() throws JsonProcessingException {
            var answer = new EmptyAnswer();
            var answerConverter = new AnswerConverter();
            var json = answerConverter.convertToJson(answer);
            assertEquals("{\"@type\":\"EmptyAnswer\",\"content\":\"\"}", json);
        }
    }

    @Nested
    @DisplayName("JsonはAnswerを継承したクラスに変換できる")
    class ConvertableJsonToAnswer {
        @Test
        @DisplayName("JsonをSingleChoiceAnswerクラスに変換できる")
        void testJsonToSingleChoiceAnswerConversion() throws JsonProcessingException {
            var json = "{\"@type\":\"SingleChoiceAnswer\",\"content\":0}";
            var answerConverter = new AnswerConverter();
            var answer = answerConverter.convertToAnswer(json);
            assertEquals(new SingleChoiceAnswer(0), answer);
        }

        @Test
        @DisplayName("JsonをMultipleChoiceAnswerクラスに変換できる")
        void testJsonToMultipleChoiceAnswerConversion() throws JsonProcessingException {
            var json = "{\"@type\":\"MultipleChoiceAnswer\",\"content\":[0,1,2]}";
            var answerConverter = new AnswerConverter();
            var answer = answerConverter.convertToAnswer(json);
            assertEquals(new MultipleChoiceAnswer(Arrays.asList(0, 1, 2)), answer);
        }

        @Test
        @DisplayName("JsonをDescriptionAnswerクラスに変換できる")
        void testJsonToDescriptionAnswerConversion() throws  JsonProcessingException {
            var json = "{\"@type\":\"DescriptionAnswer\",\"content\":\"It was written\"}";
            var answerConverter = new AnswerConverter();
            var answer = answerConverter.convertToAnswer(json);
            assertEquals(new DescriptionAnswer("It was written"), answer);
        }

        @Test
        @DisplayName("JsonをSingleChoiceAndDescriptionAnswerクラスに変換できる")
        void testJsonToSingleChoiceAndDescriptionAnswerConversion() throws JsonProcessingException {
            var json = "{\"@type\":\"SingleChoiceAndDescriptionAnswer\",\"content\":{" +
                    "\"singleChoiceAnswer\":{\"@type\":\"SingleChoiceAnswer\",\"content\":0}," +
                    "\"descriptionAnswer\":{\"@type\":\"DescriptionAnswer\",\"content\":\"It was written\"}}}";
            var answerConverter = new AnswerConverter();
            var answer = answerConverter.convertToAnswer(json);
            var expected = new SingleChoiceAndDescriptionAnswer(new SingleChoiceAndDescription(
                    new SingleChoiceAnswer(0),
                    new DescriptionAnswer("It was written")));
            assertEquals(expected, answer);
        }

        @Test
        @DisplayName("JsonをEmptyAnswerクラスに変換できる")
        void testJsonToEmptyAnswerConversion() throws  JsonProcessingException {
            var json = "{\"@type\":\"EmptyAnswer\",\"content\":\"\"}";
            var answerConverter = new AnswerConverter();
            var answer = answerConverter.convertToAnswer(json);
            assertEquals(new EmptyAnswer(), answer);
        }
    }
}
