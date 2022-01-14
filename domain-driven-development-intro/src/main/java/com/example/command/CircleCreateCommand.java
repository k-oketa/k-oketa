package com.example.command;

import lombok.Getter;

@Getter
public record CircleCreateCommand(String userId, String name) {

}
