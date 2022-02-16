package com.example.controller.response;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.lang.Nullable;

@Getter
@Setter
public class CreatedResponseContent extends ResponseContent {

    @Nullable
    private final int createdCount;

    public CreatedResponseContent(@Nullable int createdCount) {
        super(HttpStatus.CREATED);
        this.createdCount = createdCount;
    }
}
