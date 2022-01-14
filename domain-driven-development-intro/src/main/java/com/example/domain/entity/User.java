package com.example.domain.entity;

import com.example.domain.value.UserId;
import com.example.domain.value.UserName;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
public class User {

    @NonNull private final UserId id;

    @Setter
    @NonNull
    private UserName name;

    public User(UserName name) {
        this.id = new UserId(Guid.NewGuid().ToString());
        this.name = name;
    }

    public User(UserId id, UserName name) {
        this.id = id;
        this.name = name;
    }


}
