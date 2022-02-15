package com.example;

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
    public void send() {
        var newAccount = new SignUpForm();
        newAccount.setUsername("");
        newAccount.setPassphrase("k-oketa");
        rest.postForLocation("http://localhost:8080/signUp", newAccount);
    }

    @PostMapping("signUp")
    public void signUp(@RequestBody @Validated SignUpForm signUpForm,
                       BindingResult result) {
        if (result.hasErrors()) {
            System.out.println("error!");
        }
        System.out.println(signUpForm.getUsername() + " " + signUpForm.getPassphrase());
    }
}
