package com.example;

import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;

@Component
public class Query implements GraphQLQueryResolver {

    CompletableFuture<Post> getPost(Long id) {
        return CompletableFuture.supplyAsync(() -> new Post(id));
    }
}
