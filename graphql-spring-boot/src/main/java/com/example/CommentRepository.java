package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CommentRepository {

    private final JdbcTemplate jdbc;

    @Autowired
    public CommentRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public List<Comment> findByPostId(Long postId) {
        var sql = "select * from comment where post_id = ?";
        return jdbc.query(sql, new BeanPropertyRowMapper<>(Comment.class), postId);
    }

    private List<Comment> findByPostIds(List<Post> posts) {
        var sql = "select * from comment where post_id = ?";
        var post_ids = posts.stream().map(Post::getId).collect(Collectors.toList());
        jdbc.query();
    }
}
