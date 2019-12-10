package com.example.demo.service;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
class UserServiceTest {

    @Autowired
    private UserService userService;

    @Value("${spring.datasource.url}")
    private String DB_URL;

    @Value("${spring.datasource.username}")
    private String DB_USER_NAME;

    @Value("${spring.datasource.password}")
    private String DB_PASSWORD;


    @Test
    void createUser() throws Exception {
        userService.createUser("13311111111","000000");
        userService.createUser("13322222222","111111");
    }

    @Test
    void getUser() {
    }

    @Test
    void updateUser() {
    }

    @Test
    void deleteUserByUserId() {
    }

    @Test
    void testConnection() throws SQLException {
        System.out.println("DB_URL: "+DB_URL);
        System.out.println("DB_USER_NAME: "+DB_USER_NAME);
        System.out.println("DB_PASSWORD: "+DB_PASSWORD);
        Connection conn = DriverManager.getConnection(DB_URL, DB_USER_NAME, DB_PASSWORD);
        boolean reachable = conn.isValid(10);// 10 sec
    }
}