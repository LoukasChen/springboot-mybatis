package com.csp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.core.annotation.Order;

/**
 *禁用自动配置单数据源
 * @author csp
 */
@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class})
@ServletComponentScan
@Order(2)
public class SpringbootMybatisApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootMybatisApplication.class, args);
    }

    @Override
    public void run(String... args) {
        System.out.println("启动参数"+args);
    }
}
