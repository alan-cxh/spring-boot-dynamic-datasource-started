package com.apedad.example.service;

import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.RandomUtils;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UserServiceTest {
    private static final Logger LOG = Logger.getLogger(UserServiceTest.class);

    @Autowired
    private UserService userService;
    @Autowired
    private PostUserService postUserService;
    @Autowired
    private UserInfoService userInfoService;

    /**
     * 测试所有库的数据 - 读取
     */
    @Test
    public void readAllDBTest() {
        LOG.info("来自slave1库表数据：" + JSON.toJSONString(postUserService.list()));
        LOG.info("来自master库表数据：" + JSON.toJSONString(userService.listAll()));
        LOG.info("来自other库表数据：" + JSON.toJSONString(userInfoService.listAll()));
    }

    /**
     * master
     */
    @Test
    public void listAll() {
        LOG.info("user表数据：" + JSON.toJSONString(userService.listAll()));
    }

    @Test
    public void testRandom() {
        for (int i = 0; i < 100; i++) {
            LOG.info(RandomUtils.nextInt(0, 2));
        }
    }
}
