package com.example;

import graphql.kickstart.tools.GraphQLResolver;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class PostResolver implements GraphQLResolver<Post> {

    private final Map<Long, List<Comment>> comments = new HashMap<>();

    PostResolver() {
        comments.put(1L, Collections.singletonList(new Comment(1L, "Some Comment")));
    }

    public List<Comment> getComments(Post post) {
        return Optional.ofNullable(comments.get(post.getId()))
                .orElseGet(Collections::emptyList);
    }
}
