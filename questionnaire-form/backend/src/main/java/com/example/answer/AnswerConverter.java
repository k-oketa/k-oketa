package com.example.answer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;
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
        }
        return mapper.readValue(json, SingleChoiceAnswer.class);
    }
}
