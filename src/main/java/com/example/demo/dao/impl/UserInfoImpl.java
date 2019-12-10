package com.example.demo.dao.impl;

import com.example.demo.dao.UserInfoMapper;
import com.example.demo.pojo.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserInfoImpl implements UserInfoMapper {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UserInfoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void createUser(String tel,String pwd) {
        jdbcTemplate.update("INSERT INTO blog.tp_user(tel,password,nickname,secret) VALUES (?,md5(?),?,'')",tel,pwd,tel);
    }

    @Override
    public UserInfo getUser(Integer id) {
        List<UserInfo> userList = jdbcTemplate.query("select tel,nickname,password FROM blog.tp_user WHERE user_id = ?",new Object[]{id},new BeanPropertyRowMapper(UserInfo.class));
        if(userList != null && userList.size() > 0){
            return userList.get(0);
        }else {
            return null;
        }
    }

    @Override
    public void updateUser(String user_id, String nickName) {
        jdbcTemplate.update("UPDATE blog.tp_user SET nickname = ? WHERE user_id = ?",nickName,user_id);
    }

    @Override
    public void deleteUserByUserId(Integer id) {
        jdbcTemplate.update("DELETE FROM blog.tp_user WHERE user_id = ?",id);
    }
}