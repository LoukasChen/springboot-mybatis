//package com.csp.config;
//
//import com.alibaba.druid.filter.config.ConfigTools;
//import com.alibaba.druid.pool.DruidDataSource;
//import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import javax.sql.DataSource;
//
///**
// * 配置多数据源
// */
//@Configuration
//public class DataSourceConfig {
//
//    @Value("${PublicKey_Oracle}")
//    private String publicKeyOracle;
//
//    @Value("${spring.datasource.oracle.password}")
//    private String passwordOracle;
//
//    @Value("${PublicKey_Mysql}")
//    private String publicKeyMysql;
//
//    @Value("${spring.datasource.mysql.password}")
//    private String passwordMysql;
//
//    @Bean
//    //@Primary
//    @ConfigurationProperties(prefix = "spring.datasource.oracle")
//    public DataSource primaryDataSource() throws Exception {
//        DruidDataSource druidDataSource = DruidDataSourceBuilder.create().build();
//        String password = ConfigTools.decrypt(publicKeyOracle, passwordOracle);
//        druidDataSource.setPassword(password);
//        return druidDataSource;
//    }
//
//    @Bean
//    @ConfigurationProperties(prefix = "spring.datasource.mysql")
//    public DataSource mysqlDataSource() throws Exception {
//        DruidDataSource druidDataSource = DruidDataSourceBuilder.create().build();
//        String password = ConfigTools.decrypt(publicKeyMysql, passwordMysql);
//        druidDataSource.setPassword(password);
//        return druidDataSource;
//    }
//}
