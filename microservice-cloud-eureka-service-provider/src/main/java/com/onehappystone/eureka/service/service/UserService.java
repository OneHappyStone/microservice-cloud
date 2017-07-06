package com.onehappystone.eureka.service.service;

import com.onehappystone.eureka.service.entity.User;

import java.util.List;

/**
 * Created by happy on 2017/7/3.
 */
public interface UserService {
    List<User> findAllUsers();
}
