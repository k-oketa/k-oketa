package com.example.domain.specification;

import com.example.domain.entity.User;
import com.example.domain.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserSpecification {

    private final IUserRepository userRepository;

    @Autowired
    public UserSpecification(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean isUnique(User user) {
        var result = userRepository.find(user.getUserName());
        return result == null;
    }
}
