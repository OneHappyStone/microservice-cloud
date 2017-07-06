package com.onehappystone.eureka.service.service.impl;

import com.onehappystone.eureka.service.dao.UserMapper;
import com.onehappystone.eureka.service.entity.User;
import com.onehappystone.eureka.service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by happy on 2017/7/3.
 */
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserMapper userMapper;

    @Transactional(readOnly = true, propagation = Propagation.REQUIRED)
    @Override
    public List<User> findAllUsers() {
        return userMapper.selectByEntity(new User());
    }
}
