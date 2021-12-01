package com.example;

import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;

@Component
public class Query implements GraphQLQueryResolver {

    private final PostRepository postRepository;

    @Autowired
    public Query(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    CompletableFuture<Post> getPost(Long id) {
        return CompletableFuture.supplyAsync(() -> postRepository.findById(id));
    }
}
