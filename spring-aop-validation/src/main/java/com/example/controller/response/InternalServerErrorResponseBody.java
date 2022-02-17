package com.example.controller.response;

import lombok.Getter;

@Getter
public class InternalServerErrorResponseBody {

    private final String exception;

    public InternalServerErrorResponseBody(Throwable error) {
        this.exception = error.getClass().getSimpleName();
    }
}
