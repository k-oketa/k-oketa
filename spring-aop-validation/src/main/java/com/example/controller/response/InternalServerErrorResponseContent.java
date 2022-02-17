package com.example.controller.response;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
class InternalServerErrorResponseContent extends ResponseContent<InternalServerErrorResponseBody> {
    InternalServerErrorResponseContent(String message, Throwable error) {
        super(HttpStatus.INTERNAL_SERVER_ERROR, message, new InternalServerErrorResponseBody(error));
    }
}
