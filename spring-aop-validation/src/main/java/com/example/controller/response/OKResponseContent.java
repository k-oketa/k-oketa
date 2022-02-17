package com.example.controller.response;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class OKResponseContent extends ResponseContent<OKResponseBody> {
    public OKResponseContent(String message) {
        super(HttpStatus.OK, message, new OKResponseBody());
    }
}
