package com.example.controller.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.lang.Nullable;

@AllArgsConstructor
@Getter
abstract class ResponseContent {
    public final HttpStatus status;
    @Nullable public final String message;
}
