//package com.apedad.example.configuration.db;
//
//import com.alibaba.druid.pool.DruidDataSource;
//import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
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
//
///**
// * @author Administrator
// */
//@MapperScan(basePackages = OtherDataSourceConfiguration.PACKAGE, sqlSessionFactoryRef = "otherSqlSessionFactory")
//@Configuration
//public class OtherDataSourceConfiguration {
//
//    // 精确到 other 目录，以便跟其他数据源隔离
//    static final String PACKAGE = "com.apedad.example.dao";
//    static final String MAPPER_LOCATION = "classpath:mapper/mysql01/*.xml";
//
//    @Value("${multiple.datasource.other.url}")
//    private String url;
//
//    @Value("${multiple.datasource.other.username}")
//    private String user;
//
//    @Value("${multiple.datasource.other.password}")
//    private String password;
//
//    @Value("${multiple.datasource.other.driver-class-name}")
//    private String driverClass;
//
//
//    @Bean(name = "otherDataSource")
//    public DataSource otherDataSource() {
//        DruidDataSource dataSource = new DruidDataSource();
//        dataSource.setDriverClassName(driverClass);
//        dataSource.setUrl(url);
//        dataSource.setUsername(user);
//        dataSource.setPassword(password);
//        return dataSource;
//    }
//
//    @Bean(name = "otherTransactionManager")
//    public DataSourceTransactionManager otherTransactionManager() {
//        return new DataSourceTransactionManager(otherDataSource());
//    }
//
//    @Bean(name = "otherSqlSessionFactory")
//    public SqlSessionFactory otherSqlSessionFactory(@Qualifier("otherDataSource") DataSource otherDataSource)
//            throws Exception {
//        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
//        sessionFactory.setDataSource(otherDataSource);
//        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver()
//                .getResources(OtherDataSourceConfiguration.MAPPER_LOCATION));
//        return sessionFactory.getObject();
//    }
//}
