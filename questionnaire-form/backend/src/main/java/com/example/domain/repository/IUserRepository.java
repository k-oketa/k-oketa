package com.example.domain.repository;

import com.example.domain.entity.User;
import com.example.domain.value.UserName;

public interface IUserRepository {
    User find(UserName userName);
}
