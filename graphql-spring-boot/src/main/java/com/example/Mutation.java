package com.example;

import graphql.kickstart.tools.GraphQLMutationResolver;
import org.springframework.stereotype.Component;

import java.security.SecureRandom;

@Component
public class Mutation implements GraphQLMutationResolver {

    public Post createPost(String text) {
        var post = new Post(new SecureRandom().nextLong());
        post.setText(text);
        return post;
    }
}
