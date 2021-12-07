package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class PostRepository {

    private final JdbcTemplate jdbc;

    @Autowired
    public PostRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public Post findById(Long id) {
        var sql = "select * from post where id = ?";
        return jdbc.queryForObject(sql, new BeanPropertyRowMapper<>(Post.class), id);
    }
}
