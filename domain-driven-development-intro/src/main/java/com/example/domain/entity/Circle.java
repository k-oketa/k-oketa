package com.example.domain.entity;

import com.example.domain.value.CircleId;
import com.example.domain.value.CircleName;
import lombok.Getter;
import lombok.NonNull;

import java.util.List;

@Getter
public class Circle {

    @NonNull private final CircleId id;
    @NonNull private CircleName name;
    @NonNull private User owner;
    @NonNull private List<User> members;

    public Circle(CircleId id, CircleName name, User owner, List<User> members) {
        this.id = id;
        this.name = name;
        this.owner = owner;
        this.members = members;
    }
}
