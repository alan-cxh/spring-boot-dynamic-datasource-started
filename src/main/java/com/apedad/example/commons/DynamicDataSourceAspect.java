package com.apedad.example.commons;

import com.apedad.example.utils.DataCacheUtils;
import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;



@Aspect
@Order(-1)
@Component
public class DynamicDataSourceAspect {
    private static final Logger LOG = Logger.getLogger(DynamicDataSourceAspect.class);

    @Pointcut("execution(* com.apedad.example.service.*.list*(..))")
    public void pointCut() {
    }

    @Before(value = "pointCut()")
    public void doBeforeWithSlave(JoinPoint joinPoint) {
        //获取当前切点方法对象
        DataSourceKey dataSourceKey = (DataSourceKey) DataCacheUtils.currentDataSourceCache.get(Constant.DATA_SOURCE_TYPE);
        if (dataSourceKey != null) {
            DynamicDataSourceContextHolder.set(dataSourceKey);
        } else {
            DynamicDataSourceContextHolder.set(DataSourceKey.DB_MASTER);
        }
    }
}
