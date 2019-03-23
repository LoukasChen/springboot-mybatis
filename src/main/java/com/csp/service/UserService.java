package com.csp.service;

import com.csp.entity.User;

import java.util.List;

public interface UserService {
    User selectById(Integer id);

    List<User> selectList();

    int add(User user);

    int updateById(User user);

    int deleteById(Integer id);
}
