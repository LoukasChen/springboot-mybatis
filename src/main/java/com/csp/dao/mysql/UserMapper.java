package com.csp.dao.mysql;

import com.csp.entity.User;

import java.util.List;

public interface UserMapper {

    User selectById(Integer id);

    List<User> selectList();

    int add(User user);

    int updateById(User user);

    int deleteById(Integer id);
}
