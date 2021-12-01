package com.example;

import graphql.kickstart.tools.GraphQLResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class PostResolver implements GraphQLResolver<Post> {

    private final CommentRepository commentRepository;

    @Autowired
    public PostResolver(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
//        comments.put(1L, Collections.singletonList(new Comment(1L, "Some Comment")));
    }

    public List<Comment> getComments(Post post) {
        return commentRepository.findByPostId(post.getId());
//        return Optional.ofNullable(comments.get(post.getId()))
//                .orElseGet(Collections::emptyList);
    }
}
