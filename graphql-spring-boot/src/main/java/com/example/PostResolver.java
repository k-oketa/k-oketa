package com.example;

import graphql.kickstart.tools.GraphQLResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class PostResolver implements GraphQLResolver<Post> {

    private final CommentService commentService;

    @Autowired
    public PostResolver(CommentService commentService) {
        this.commentService = commentService;
        // もう使わないけど、初めてみるメソッドなので残しておきます。
        // comments.put(1L, Collections.singletonList(new Comment(1L, "Some Comment")));
    }

    public List<Comment> getComments(Post post) {
        return Optional.ofNullable(commentService.getPostedComments(post))
                .orElseGet(Collections::emptyList);
    }
}
