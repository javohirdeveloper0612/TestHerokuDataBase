package org.example.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ProfileRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public String getProfileList() {
        String sql = "select name from card1 where id = 1";

        return jdbcTemplate.queryForObject(sql, String.class);
    }

    public int addTable(){
        String sql = "create table card1( id serial," +
                "name varchar )";

        System.out.println(sql);
       return jdbcTemplate.update(sql);
    }

    public int addProfile(){
        String sql = "insert into card1(name) values (?)";

        return jdbcTemplate.update(sql,"Ali");
    }
}
