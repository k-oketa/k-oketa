package com.example.controller.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class OKResponseEntity extends ResponseEntity<OKResponseContent> {
    public OKResponseEntity(String message) {
        super(new OKResponseContent(message), HttpStatus.OK);
    }
}
