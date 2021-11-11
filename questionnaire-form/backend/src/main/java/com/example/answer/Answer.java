package com.example.answer;

public record Answer(String content) {

    String getContent() {
        return content;
    }

}
