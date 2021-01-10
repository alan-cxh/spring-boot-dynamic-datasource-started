package com.apedad.example.service;

import com.apedad.example.entity.UserInfo;

import java.util.List;


public interface UserInfoService {
    List<UserInfo> listAll();

    int insert(UserInfo userInfo);
}
