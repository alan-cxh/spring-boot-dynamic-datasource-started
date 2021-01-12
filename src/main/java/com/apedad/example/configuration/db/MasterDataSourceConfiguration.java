//package com.apedad.example.configuration.db;
//
//import com.alibaba.druid.pool.DruidDataSource;
//import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
//import com.apedad.example.commons.DataSourceKey;
//import com.apedad.example.commons.DynamicRoutingDataSource;
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.mybatis.spring.SqlSessionFactoryBean;
//import org.mybatis.spring.SqlSessionTemplate;
//import org.mybatis.spring.annotation.MapperScan;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
//import org.springframework.jdbc.datasource.DataSourceTransactionManager;
//
//import javax.sql.DataSource;
//import java.util.HashMap;
//import java.util.Map;
//
//@MapperScan(basePackages = MasterDataSourceConfiguration.PACKAGE, sqlSessionFactoryRef = "masterSqlSessionFactory")
//@Configuration
//public class MasterDataSourceConfiguration {
//
//    // 精确到 master 目录，以便跟其他数据源隔离
//    static final String PACKAGE = "com.apedad.example.dao";
//    static final String MAPPER_LOCATION = "classpath:mapper/mysql01/*.xml";
//
//    @Value("${multiple.datasource.master.url}")
//    private String url;
//
//    @Value("${multiple.datasource.master.username}")
//    private String user;
//
//    @Value("${multiple.datasource.master.password}")
//    private String password;
//
//    @Value("${multiple.datasource.master.driver-class-name}")
//    private String driverClass;
//
//
//    @Bean(name = "masterDataSource")
//    @Primary
//    public DataSource masterDataSource() {
//        DruidDataSource dataSource = new DruidDataSource();
//        dataSource.setDriverClassName(driverClass);
//        dataSource.setUrl(url);
//        dataSource.setUsername(user);
//        dataSource.setPassword(password);
//        return dataSource;
//    }
//
//    @Bean(name = "masterTransactionManager")
//    @Primary
//    public DataSourceTransactionManager masterTransactionManager() {
//        return new DataSourceTransactionManager(masterDataSource());
//    }
//
//    @Bean(name = "masterSqlSessionFactory")
//    @Primary
//    public SqlSessionFactory masterSqlSessionFactory(@Qualifier("masterDataSource") DataSource masterDataSource)
//            throws Exception {
//        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
//        sessionFactory.setDataSource(masterDataSource);
//        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver()
//                .getResources(MasterDataSourceConfiguration.MAPPER_LOCATION));
//        return sessionFactory.getObject();
//    }
//
//}