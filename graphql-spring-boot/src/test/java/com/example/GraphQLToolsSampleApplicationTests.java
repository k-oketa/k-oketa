package com.example;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.graphql.spring.boot.test.GraphQLTest;
import com.graphql.spring.boot.test.GraphQLTestTemplate;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureJdbc;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@GraphQLTest
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class GraphQLToolsSampleApplicationTests {

    private final GraphQLTestTemplate template;

    @Autowired
    public GraphQLToolsSampleApplicationTests(GraphQLTestTemplate template) {
        this.template = template;
    }

    @Test
    void testGetComments() throws IOException {
        var response = template.postForResource(
                "graphql/post-get-comments.graphql");
        assertNotNull(response);
        assertTrue(response.isOk());
        assertEquals(response.get("$.data.post.id"), "1");
    }

    @Test
    void testGetCommentsWithFragment() throws IOException {
        var fragments = new ArrayList<String>();
        fragments.add("graphql/all-comment-fields-fragment.graphql");
        var response = template.postForResource(
                "graphql/post-get-comments-with-fragment.graphql", fragments);
        assertNotNull(response);
        assertTrue(response.isOk());
        assertEquals(response.get("$.data.post.id"), "1");
    }

    @Test
    void testCreatePost() throws IOException {
        var variables = new ObjectMapper().createObjectNode();
        variables.put("text", "lorem ipsum dolor sit amet");
        var response = template.perform("graphql/create-post.graphql", variables);
        assertTrue(response.isOk());
        assertNotNull(response.get("$.data.createPost.id"));
    }
}
