package com.example;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class SignUpController {

    private final RestTemplate rest;

    @Autowired
    public SignUpController(RestTemplate rest) {
        this.rest = rest;
    }

    @GetMapping("send")
    public String send() {
        var newAccount = new SignUpForm();
        newAccount.setUsername("k-oketa");
        newAccount.setPassphrase("k-oketa");
        return rest.postForObject("http://localhost:8080/signUp", newAccount, String.class);
    }

    @PostMapping("signUp")
    public String signUp(@RequestBody SignUpForm signUpForm) {
        new Account(signUpForm.getUsername(), signUpForm.getPassphrase());
        return "";
    }
}
