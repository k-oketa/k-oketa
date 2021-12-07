package com.example;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Comment {

    private Long id;
    private Long postId;
    private String description;
}
