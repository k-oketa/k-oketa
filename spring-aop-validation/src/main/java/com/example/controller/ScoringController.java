package com.example.controller;

import com.example.controller.response.CreatedResponseEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class ScoringController {

    @PostMapping("scoring")
    public ResponseEntity<?> score() {
        return new CreatedResponseEntity("スコアを保存しました。", 1);
    }
}
