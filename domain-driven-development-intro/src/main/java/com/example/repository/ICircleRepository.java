package com.example.repository;

import com.example.domain.entity.Circle;
import com.example.domain.value.CircleId;
import com.example.domain.value.CircleName;

public interface ICircleRepository {
    void save(Circle circle);
    Circle find(CircleId id);
    Circle find(CircleName name);
}
