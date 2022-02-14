package com.example.app.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class SurveyCreationControllerTests {

    private final MockMvc mvc;

    @Autowired
    SurveyCreationControllerTests(MockMvc mvc) {
        this.mvc = mvc;
    }

    @Test
    void receivePostRequest() throws Exception {
        var json = """
                {
                    "title": "数学に関するアンケート",
                    "agreementBody": "回答はコンピテンシーの研究に活用します。",
                    "questions": [
                        {
                            "body": "この授業で学んだことを今後どのように活かしたいですか？",
                            "type": "description",
                            "contents": {}
                        }
                    ]
                }
                """;
        mvc.perform(post("/survey/creation").content(json))
                .andExpect(status().isOk());
    }
}
