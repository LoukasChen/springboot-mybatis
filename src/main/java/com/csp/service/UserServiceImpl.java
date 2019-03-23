package com.csp.service;

import com.csp.dao.mysql.UserMapper;
import com.csp.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User selectById(Integer id) {
        return userMapper.selectById(id);
    }

    @Override
    public List<User> selectList() {
        return userMapper.selectList();
    }

    @Override
    public int add(User user) {
        return userMapper.add(user);
    }

    @Override
    public int updateById( User user) {
        return userMapper.updateById(user);
    }

    @Override
    public int deleteById(Integer id) {
        return userMapper.deleteById(id);
    }
}
