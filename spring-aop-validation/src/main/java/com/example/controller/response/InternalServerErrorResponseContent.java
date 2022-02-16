package com.example.controller.response;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
class InternalServerErrorResponseContent extends ResponseContent {

    private final String exception;

    InternalServerErrorResponseContent(Throwable error) {
        super(HttpStatus.INTERNAL_SERVER_ERROR, error.getMessage());
        this.exception = error.getClass().getSimpleName();
    }
}
