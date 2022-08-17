package org.lxh.service;

import org.lxh.annotation.MyDataSource;
import org.lxh.mapper.UserMapper;
import org.lxh.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserMapper userMapper;

    @MyDataSource("slave")
    public List<User> getAllUsers(){
        return userMapper.getAllUsers();
    }
}
