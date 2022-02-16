package com.example;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class Account {
    private Username username;
    private Passphrase passphrase;

    public Account(String username, String passphrase) throws IllegalArgumentException {
        this.username = new Username(username);
        this.passphrase = new Passphrase(passphrase);
    }
}
