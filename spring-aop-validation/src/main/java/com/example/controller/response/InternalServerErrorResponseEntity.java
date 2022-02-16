package com.example.controller.response;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Getter
public class InternalServerErrorResponseEntity extends ResponseEntity<InternalServerErrorResponseContent> {
    public InternalServerErrorResponseEntity(Throwable throwable) {
        super(new InternalServerErrorResponseContent(throwable), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
