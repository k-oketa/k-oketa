package com.example.domain.entity;

import com.example.domain.value.UserId;
import com.example.domain.value.UserName;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class User {

    private final UserId userId;
    private UserName userName;
}
