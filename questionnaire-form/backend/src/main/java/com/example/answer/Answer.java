package com.example.answer;

public record Answer(String type, String content) {

    String getType() {
        return type;
    }

    String getContent() {
        return content;
    }

}
