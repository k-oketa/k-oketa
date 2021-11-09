package com.example.question;

import lombok.Getter;

import java.util.List;

public class Question extends Ordinal {

    @Getter
    private final String body;
    String questionType;

    private Question(int number, String body) {
        super(number);
        this.body = body;
    }

    @Getter
    private static class SingleChoiceQuestion extends Question {

        private final List<Option> options;

        private SingleChoiceQuestion(int number, String body, List<Option> options) {
            super(number, body);
            this.options = options;
            this.questionType = "singleChoice";
        }
    }

    public SingleChoiceQuestion singleChoiceQuestion(int number, String body, List<Option> options) {
        return new SingleChoiceQuestion(number, body, options);
    }

    @Getter
    private static class MultipleChoiceQuestion extends Question {

        private final List<Option> options;

        private MultipleChoiceQuestion(int number, String body, List<Option> options) {
            super(number, body);
            this.options = options;
            this.questionType = "multipleChoice";
        }
    }

    public MultipleChoiceQuestion multipleChoiceQuestion(int number, String body, List<Option> options) {
        return new MultipleChoiceQuestion(number, body, options);
    }

    @Getter
    private static class DescriptionQuestion extends Question {
        private DescriptionQuestion(int number, String body) {
            super(number, body);
            this.questionType = "description";
        }
    }

    public DescriptionQuestion descriptionQuestion(int number, String body) {
        return new DescriptionQuestion(number, body);
    }

    @Getter
    private static class SingleChoiceDescriptionQuestion extends Question {

        private final List<Option> options;

        private SingleChoiceDescriptionQuestion(int number, String body, List<Option> options) {
            super(number, body);
            this.options = options;
            this.questionType = "singleChoiceDescription";
        }
    }

    public SingleChoiceDescriptionQuestion singleChoiceDescriptionQuestion(int number, String body, List<Option> options) {
        return new SingleChoiceDescriptionQuestion(number, body, options);
    }
}
