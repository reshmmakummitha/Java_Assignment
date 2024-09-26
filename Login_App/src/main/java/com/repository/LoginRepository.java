package com.repository;
import org.springframework.jdbc.core.JdbcTemplate;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;

import com.model.Login;



@Repository

public class LoginRepository {



    @Autowired

    private JdbcTemplate jdbcTemplate;



    public void save(Login login) {

        String sql = "INSERT INTO users (emailid, password, typeofuser) VALUES (?, ?, ?)";

        jdbcTemplate.update(sql, login.getEmailid(), login.getPassword(), login.getTypeofuser());

    }



    public boolean validateUser(String emailid, String password, String typeofuser) {

        String sql = "SELECT COUNT(*) FROM users WHERE emailid = ? AND password = ? AND typeofuser = ?";

        int count = jdbcTemplate.queryForObject(sql, new Object[]{emailid, password, typeofuser}, Integer.class);

        return count > 0;

    }

}

