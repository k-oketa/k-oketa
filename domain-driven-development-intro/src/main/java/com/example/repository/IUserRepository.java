package com.example.repository;

import com.example.domain.entity.User;
import com.example.domain.value.UserId;
import com.example.domain.value.UserName;

public interface IUserRepository {
    User find(UserId id);
    User find(UserName name);
    void save(User user);
}
