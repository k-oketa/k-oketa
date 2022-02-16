package com.example.controller.response;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class OKResponseContent extends ResponseContent {
    public OKResponseContent(String message) {
        super(HttpStatus.OK, message);
    }
}
