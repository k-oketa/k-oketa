package com.example.domain.service;

import com.example.domain.entity.User;
import com.example.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserService {

    private final IUserRepository userRepository;

    @Autowired
    public UserService(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean exists(User user) {
        var duplicatedUser = userRepository.find(user.getName());
        return duplicatedUser != null;
    }
}
