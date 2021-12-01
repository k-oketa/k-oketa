package com.example;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Post {

    private Long id;

    private String text;

    public Post(Long id) {
        this.id = id;
    }


}
