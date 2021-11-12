package com.example.answer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.Map;

public class AnswerConverter {

    <T> String convertToJson(T answer) throws JsonProcessingException {
        var mapper = new ObjectMapper();
        return mapper.writeValueAsString(answer);
    }

    Answer convertToAnswer(String json) throws JsonProcessingException {
        var mapper = new ObjectMapper();
        var factory = mapper.getTypeFactory();
        var map = (Map) mapper.readValue(json, factory.constructType(Map.class));
        var answerType = map.get("@type");
        if (answerType.equals("SingleChoiceAnswer")) {
            return new SingleChoiceAnswer((Integer) map.get("content"));
        } else if (answerType.equals("MultipleChoiceAnswer")) {
            return new MultipleChoiceAnswer((ArrayList<Integer>) map.get("content"));
        } else if (answerType.equals("DescriptionAnswer")) {
            return new DescriptionAnswer((String) map.get("content"));
        } else if (answerType.equals("SingleChoiceAndDescriptionAnswer")) {
            var content = (Map) map.get("content");
            var singleChoiceAnswer = new SingleChoiceAnswer(
                    (Integer) ((Map) content.get("singleChoiceAnswer")).get("content"));
            var descriptionAnswer = new DescriptionAnswer(
                    (String) ((Map) content.get("descriptionAnswer")).get("content"));
            return new SingleChoiceAndDescriptionAnswer(
                    new SingleChoiceAndDescription(singleChoiceAnswer, descriptionAnswer));
        }
        return mapper.readValue(json, SingleChoiceAnswer.class);
    }
}
