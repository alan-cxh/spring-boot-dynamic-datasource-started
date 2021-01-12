package com.apedad.example.service.impl;

import com.apedad.example.dao.UserInfoMapper;
import com.apedad.example.entity.UserInfo;
import com.apedad.example.service.UserInfoService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service("userInfoService")
public class UserInfoServiceImpl implements UserInfoService {
    private static final Logger LOG = Logger.getLogger(UserInfoServiceImpl.class);
    @Resource
    private UserInfoMapper userInfoMapper;

    @Override
    public List<UserInfo> listAll() {
        return userInfoMapper.listAll();
    }

    @Override
    public int insert(UserInfo userInfo) {
        return userInfoMapper.insert(userInfo);
    }
}
