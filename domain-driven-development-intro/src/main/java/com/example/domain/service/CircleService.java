package com.example.domain.service;

import com.example.domain.entity.Circle;
import com.example.repository.ICircleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CircleService {

    private final ICircleRepository circleRepository;

    @Autowired
    public CircleService(ICircleRepository circleRepository) {
        this.circleRepository = circleRepository;
    }

    public boolean exist(Circle circle) {
        var duplicated = circleRepository.find(circle.getName());
        return duplicated != null;
    }
}
