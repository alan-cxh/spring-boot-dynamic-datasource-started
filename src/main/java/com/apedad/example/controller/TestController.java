package com.apedad.example.controller;


import com.apedad.example.commons.Constant;
import com.apedad.example.commons.DataSourceKey;
import com.apedad.example.service.PostUserService;
import com.apedad.example.service.UserInfoService;
import com.apedad.example.service.UserService;
import com.apedad.example.utils.DataCacheUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import javax.validation.constraints.NotNull;

/**
 * @author Administrator
 */
@RestController
@RequestMapping("test")
@Slf4j
public class TestController {

    @Autowired
    PostUserService postUserService;
    @Autowired
    UserInfoService userInfoService;
    @Autowired
    UserService userService;

    /**
     * 设置数据源类型
     * @param dataSourceType
     */
    @GetMapping("setDataSourceType")
    public void setDataSourceType(@NotNull @RequestParam String dataSourceType) {
        DataCacheUtils.currentDataSourceCache.put(Constant.DATA_SOURCE_TYPE, DataSourceKey.getDataSourceValue(dataSourceType));
    }


    /**
     * user信息，来自master数据源 mySql
     * @return
     */
    @GetMapping("masterDb")
    public Object masterDb() {
        return userService.listAll();
    }

    /**
     * user信息，来自slave1数据源，pgSql
     * @return
     */
    @GetMapping("salveDb")
    public Object salveDb() {
        return postUserService.list();
    }

    /**
     * user信息，来自other数据源，mySql
     * @return
     */
    @GetMapping("otherDb")
    public Object otherDb() {
        return userInfoService.listAll();
    }
}
