package com.apedad.example.service.impl;

import com.apedad.example.dao.PostUserMapper;
import com.apedad.example.entity.PostUser;
import com.apedad.example.service.PostUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostUserServiceImpl implements PostUserService {

//    @Autowired(required = false)
//    private PostUserMapper postUserMapper;

    @Override
    public List<PostUser> list() {
//        return postUserMapper.getList();
        return null;
    }
}
