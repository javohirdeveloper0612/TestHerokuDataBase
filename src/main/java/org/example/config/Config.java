package org.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = "org.example")
public class Config {
    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgres://gswefogihbjcfi:a0f25d1ac12b2d8fae9ec7dc3360e0de04885ebd1aaf8c7f6a83017de5a21117@ec2-99-80-170-190.eu-west-1.compute.amazonaws.com:5432/dd7i8lkqjtkb51");
        dataSource.setUsername("gswefogihbjcfi");
        dataSource.setPassword("a0f25d1ac12b2d8fae9ec7dc3360e0de04885ebd1aaf8c7f6a83017de5a21117");

        return dataSource;

    }


    @Bean
    public JdbcTemplate getTemplate(){
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource((dataSource()));
        return jdbcTemplate;
    }

}
