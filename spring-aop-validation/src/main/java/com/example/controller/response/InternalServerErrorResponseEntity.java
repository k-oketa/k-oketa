package com.example.controller.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class InternalServerErrorResponseEntity extends ResponseEntity<InternalServerErrorResponseContent> {
    public InternalServerErrorResponseEntity(Throwable throwable) {
        super(new InternalServerErrorResponseContent(throwable.getMessage(), throwable), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
