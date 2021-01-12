package com.apedad.example.utils;

import com.apedad.example.commons.Constant;
import com.apedad.example.commons.DataSourceKey;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Administrator
 */
@Component
public class DataCacheUtils {

    @Value("${my.datasource.default.datasource.type:DB_MASTER}")
    private String defaultDataSourceType;

    public static Map<String, DataSourceKey> currentDataSourceCache = new ConcurrentHashMap();

    @PostConstruct
    public void initDataSource() {
        DataSourceKey dataSourceValue = DataSourceKey.getDataSourceValue(defaultDataSourceType);
        currentDataSourceCache.put(Constant.DATA_SOURCE_TYPE, dataSourceValue);
    }
}
