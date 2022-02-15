package com.example;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class SignUpForm {

    @NotBlank
    private String username;
    private String passphrase;
}
