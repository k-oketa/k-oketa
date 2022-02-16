package com.example.controller.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class CreatedResponseEntity extends ResponseEntity<CreatedResponseContent> {

    public CreatedResponseEntity() {
        super(HttpStatus.CREATED, new CreatedResponseContent());
    }

    public CreatedResponseEntity(int createdCount, String message) {
        super(new CreatedResponseContent(message, createdCount), HttpStatus.CREATED);
    }
}
