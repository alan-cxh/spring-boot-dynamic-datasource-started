package com.apedad.example.service;

import com.apedad.example.entity.User;

import java.util.List;


public interface UserService {
    List<User> listAll();

    int insert(User user);
}
