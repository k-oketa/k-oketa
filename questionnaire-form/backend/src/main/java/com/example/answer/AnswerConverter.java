package com.example.answer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class AnswerConverter {

    String convertToJson(Answer answer) throws JsonProcessingException {
        var mapper = new ObjectMapper();
        return mapper.writeValueAsString(answer);
    }
}
