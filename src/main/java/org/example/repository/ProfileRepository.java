package org.example.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ProfileRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public String getProfileList() {
        String sql = "select name from profile where id = 1";

        return jdbcTemplate.queryForObject(sql, String.class);
    }
}
