package com.csp.config;

import com.csp.entity.User;
import com.csp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 将数据初始化到内存中
 */
@Component
@Order(1)
public class StartLoadConfig implements CommandLineRunner {

    @Autowired
    private UserService userService;

    @Override
    public void run(String... strings) throws Exception {
        List<User> userList = userService.selectList();
        for (User user : userList) {
            System.out.println(user);
        }
    }
}
