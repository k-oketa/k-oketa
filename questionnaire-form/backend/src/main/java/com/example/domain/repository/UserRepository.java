package com.example.domain.repository;

import com.example.domain.entity.User;
import com.example.domain.repository.mapper.UserRowMapper;
import com.example.domain.value.UserName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository implements IUserRepository {

    private final JdbcTemplate jdbc;

    @Autowired
    public UserRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    @Override
    public User find(UserName userName) {
        var sql = "select * from user where username = ?";
        return jdbc.queryForObject(sql, new UserRowMapper(), userName.getValue());
    }
}
