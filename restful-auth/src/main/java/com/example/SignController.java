package com.example;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class SignController {

    @PostMapping(value = "signIn", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> signIn(@RequestBody SignInForm signInForm) {
        return new ResponseEntity<>(signInForm.getUsername() + signInForm.getPassword(), HttpStatus.OK);
    }
}
