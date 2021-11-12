package com.example.answer;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.jsontype.NamedType;

import javax.el.ValueExpression;

public class AnswerConverter {

    private final ObjectMapper mapper;

    AnswerConverter() {
        this.mapper = new ObjectMapper();
        this.mapper.registerSubtypes(
                new NamedType(SingleChoiceAnswer.class, "SingleChoiceAnswer"),
                new NamedType(MultipleChoiceAnswer.class, "MultipleChoiceAnswer"),
                new NamedType(DescriptionAnswer.class, "DescriptionAnswer"),
                new NamedType(SingleChoiceAndDescriptionAnswer.class, "SingleChoiceAndDescriptionAnswer"),
                new NamedType(EmptyAnswer.class, "EmptyAnswer")
        );
    }

    <T> String convertToJson(T answer) throws JsonProcessingException {
        return mapper.writeValueAsString(answer);
    }

    Answer convertToAnswer(String json) throws JsonProcessingException {
        var factory = mapper.getTypeFactory();
        var jsonNode = (JsonNode) mapper.readValue(json, factory.constructType(JsonNode.class));
        var answerType = jsonNode.get("@type").asText();
        return switch (answerType) {
            case "SingleChoiceAnswer" -> mapper.readValue(json, factory.constructType(SingleChoiceAnswer.class));
            case "MultipleChoiceAnswer" -> mapper.readValue(json, factory.constructType(MultipleChoiceAnswer.class));
            case "DescriptionAnswer" -> mapper.readValue(json, factory.constructType(DescriptionAnswer.class));
            case "SingleChoiceAndDescriptionAnswer" -> mapper.readValue(json, factory.constructType(SingleChoiceAndDescriptionAnswer.class));
            case "EmptyAnswer" -> mapper.readValue(json, factory.constructType(EmptyAnswer.class));
            default -> new EmptyAnswer();
        };
    }
}
