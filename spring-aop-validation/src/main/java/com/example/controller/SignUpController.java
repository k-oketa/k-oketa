package com.example.controller;

import com.example.Account;
import com.example.SignUpForm;
import com.example.controller.response.CreatedResponseEntity;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SignUpController {

    @PostMapping(value = "signUp", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<?> signUp(@RequestBody SignUpForm signUpForm) {
        new Account(signUpForm.getUsername(), signUpForm.getPassphrase());
        return new CreatedResponseEntity();
    }
}
