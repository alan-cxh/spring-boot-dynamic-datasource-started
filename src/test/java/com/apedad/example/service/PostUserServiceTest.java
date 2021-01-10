package com.apedad.example.service;

import com.alibaba.fastjson.JSON;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class PostUserServiceTest {
    private static final Logger LOG = Logger.getLogger(PostUserServiceTest.class);
    @Autowired
    private PostUserService postUserService;

    @Test
    public void postUserlistAll() {
        LOG.info("user表数据：" + JSON.toJSONString(postUserService.list()));
    }


}
