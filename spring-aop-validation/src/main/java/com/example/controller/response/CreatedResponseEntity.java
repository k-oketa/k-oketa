package com.example.controller.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class CreatedResponseEntity extends ResponseEntity<CreatedResponseContent> {
    public CreatedResponseEntity(String message, int createdCount) {
        super(new CreatedResponseContent(message, createdCount), HttpStatus.CREATED);
    }
}
