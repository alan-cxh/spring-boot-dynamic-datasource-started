package com.apedad.example.dao;

import com.apedad.example.entity.User;

import java.util.List;


public interface UserMapper {
    List<User> listAll();

    int insert(User user);
}
