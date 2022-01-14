package com.example.app.service;

import com.example.command.CircleCreateCommand;
import com.example.command.CircleJoinCommand;
import com.example.domain.service.CircleService;
import com.example.domain.value.CircleId;
import com.example.domain.value.CircleName;
import com.example.domain.value.UserId;
import com.example.factory.ICircleFactory;
import com.example.repository.ICircleRepository;
import com.example.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CircleApplicationService {

    private final ICircleFactory circleFactory;
    private final ICircleRepository circleRepository;
    private final CircleService circleService;
    private final IUserRepository userRepository;

    @Autowired
    public CircleApplicationService(ICircleFactory circleFactory,
                                    ICircleRepository circleRepository,
                                    CircleService circleService,
                                    IUserRepository userRepository) {
        this.circleFactory = circleFactory;
        this.circleRepository = circleRepository;
        this.circleService = circleService;
        this.userRepository = userRepository;
    }

    @Transactional
    public void create(CircleCreateCommand command) {
        var ownerId = new UserId(command.getUserId());
        var owner = userRepository.find(ownerId);
        if (owner == null) throw UserNotFoundException();
        var name = new CircleName(command.getName());
        var circle = circleFactory.create(name, owner);
        if (circleService.exist(circle)) throw new CanNotRegisterCircleException();
        circleRepository.save(circle);
    }

    @Transactional
    public void Join(CircleJoinCommand command) {
        var memberId = new UserId(command.userId());
        var member = userRepository.find(memberId);
        if (member == null) throw new UserNotFoundException();

        var id = new CircleId(command.circleId());
        var circle = circleRepository.find(id);
        if (circle == null) throw new CircleNotFoundException();
        if (circle.getMembers().size() >= 29) throw new CircleFullException();

        circle.getMembers().add(member);
        circleRepository.save(circle);
    }
}
