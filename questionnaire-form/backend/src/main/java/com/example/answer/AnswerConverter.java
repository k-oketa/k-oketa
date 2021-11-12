package com.example.answer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.jsontype.NamedType;

public class AnswerConverter {

    private final ObjectMapper mapper;

    public AnswerConverter() {
        this.mapper = new ObjectMapper();
        this.mapper.registerSubtypes(
                new NamedType(SingleChoiceAnswer.class, AnswerType.SINGLE_CHOICE.getName()),
                new NamedType(MultipleChoiceAnswer.class, AnswerType.MULTIPLE_CHOICE.getName()),
                new NamedType(DescriptionAnswer.class, AnswerType.DESCRIPTION.getName()),
                new NamedType(SingleChoiceAndDescriptionAnswer.class, AnswerType.SINGLE_CHOICE_AND_DESCRIPTION.getName()),
                new NamedType(EmptyAnswer.class, AnswerType.EMPTY.getName())
        );
    }

    public <T> String convertToJson(T answer) throws JsonProcessingException {
        return mapper.writeValueAsString(answer);
    }

    public Answer convertToAnswer(String json) throws JsonProcessingException {
        var factory = mapper.getTypeFactory();
        var jsonNode = (JsonNode) mapper.readValue(json, factory.constructType(JsonNode.class));
        var answerType = AnswerType.lookup(jsonNode.get("@type").asText());
        return switch (answerType) {
            case SINGLE_CHOICE -> mapper.readValue(json, factory.constructType(SingleChoiceAnswer.class));
            case MULTIPLE_CHOICE -> mapper.readValue(json, factory.constructType(MultipleChoiceAnswer.class));
            case DESCRIPTION -> mapper.readValue(json, factory.constructType(DescriptionAnswer.class));
            case SINGLE_CHOICE_AND_DESCRIPTION -> mapper.readValue(json, factory.constructType(SingleChoiceAndDescriptionAnswer.class));
            case EMPTY -> mapper.readValue(json, factory.constructType(EmptyAnswer.class));
        };
    }
}
