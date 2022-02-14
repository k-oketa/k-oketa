package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class GreetingTests {

    private final MockMvc mvc;

    @Autowired
    GreetingTests(MockMvc mvc) {
        this.mvc = mvc;
    }

    @Test
    void greetingWithGet() throws Exception {
        var expectedJson = "{\"id\":1,\"content\":\"Hello, World!\"}";
        mvc.perform(get("/greeting"))
                .andExpect(status().isOk())
                .andExpect(content().json(expectedJson));
    }
}
