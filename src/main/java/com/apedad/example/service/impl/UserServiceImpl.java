package com.apedad.example.service.impl;

import com.apedad.example.dao.UserMapper;
import com.apedad.example.entity.User;
import com.apedad.example.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service("userService")
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public List<User> listAll() {
        return userMapper.listAll();
    }

    @Override
    public int insert(User user) {
        return userMapper.insert(user);
    }
}
