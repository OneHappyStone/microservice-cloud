package com.onehappystone.eureka.service.api;

import com.netflix.discovery.converters.Auto;
import com.onehappystone.eureka.service.entity.User;
import com.onehappystone.eureka.service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by happy on 2017/7/3.
 */
@RestController
@RequestMapping("/user")
public class UserApi {
    @Autowired
    private UserService userService;
    
    @GetMapping("/getAll")
    public List<User> getAllUsers(){
        return userService.findAllUsers();
    }
}
