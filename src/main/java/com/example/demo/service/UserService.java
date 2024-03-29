package com.example.demo.service;

import com.example.demo.dao.UserInfoMapper;
import com.example.demo.pojo.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserInfoMapper userInfoMapper;

    @Autowired
    public UserService(UserInfoMapper userInfoMapper) {
        this.userInfoMapper = userInfoMapper;
    }

    public void createUser(String tel,String pwd) {
        userInfoMapper.createUser(tel,pwd);
    }

    public UserInfo getUser(Integer id) {
        return userInfoMapper.getUser(id);
    }

    public void updateUser(String user_id, String nickName) {
        userInfoMapper.updateUser(user_id,nickName);
    }

    public void deleteUserByUserId(Integer id) {
        userInfoMapper.deleteUserByUserId(id);
    }
}