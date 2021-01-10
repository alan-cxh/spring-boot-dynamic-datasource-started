package com.apedad.example.dao;

import com.apedad.example.entity.UserInfo;

import java.util.List;


public interface UserInfoMapper {
    List<UserInfo> listAll();

    int insert(UserInfo userInfo);
}
