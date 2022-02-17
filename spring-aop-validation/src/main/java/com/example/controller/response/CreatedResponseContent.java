package com.example.controller.response;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
class CreatedResponseContent extends ResponseContent<CreatedResponseBody> {
    CreatedResponseContent(String message, int creationCount) {
        super(HttpStatus.CREATED, message, new CreatedResponseBody(creationCount));
    }
}
