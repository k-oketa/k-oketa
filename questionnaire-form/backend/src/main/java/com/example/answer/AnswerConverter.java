package com.example.answer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class AnswerConverter {

    <T> String convertToJson(T answer) throws JsonProcessingException {
        var mapper = new ObjectMapper();
        return mapper.writeValueAsString(answer);
    }

    Answer convertToAnswer(String json, Class<? extends Answer> clazz) throws JsonProcessingException {
        var mapper = new ObjectMapper();
        return mapper.readValue(json, clazz);
    }
}
