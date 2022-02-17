package com.example.controller.response;

import org.springframework.http.HttpStatus;
import org.springframework.lang.Nullable;

import java.time.LocalDateTime;

abstract class ResponseContent<T> {
    protected final LocalDateTime timestamp;
    protected final int status;
    @Nullable protected final String message;
    @Nullable protected final T content;

    ResponseContent(HttpStatus status, String message, T content) {
        this.timestamp = LocalDateTime.now();
        this.status = status.value();
        this.message = message;
        this.content = content;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public int getStatus() {
        return status;
    }

    @Nullable
    public String getMessage() {
        return message;
    }

    @Nullable
    public T getContent() {
        return content;
    }
}
