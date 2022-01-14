package com.example.factory;

import com.example.domain.entity.Circle;
import com.example.domain.entity.User;
import com.example.domain.value.CircleName;

public interface ICircleFactory {

    Circle create(CircleName name, User owner);
}
