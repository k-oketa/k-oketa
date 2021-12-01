package com.example;

import lombok.Getter;
import lombok.Setter;

public class Post {

    @Getter
    private final Long id;

    @Getter
    @Setter
    private String text;

    public Post(Long id) {
        this.id = id;
    }


}
