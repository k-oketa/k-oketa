package com.example.domain.repository.mapper;

import com.example.domain.entity.User;
import com.example.domain.value.UserId;
import com.example.domain.value.UserName;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new User(new UserId(rs.getLong(rowNum)), new UserName(rs.getString(rowNum)));
    }
}
