package com.onehappystone.eureka.service.service;

import org.springframework.stereotype.Service;

/**
 * Created by happy on 2017/3/4.
 */
@Service
public class ProviderServiceImpl implements ProviderService{
    @Override
    public String sayHello(String name) {
        return "Hello, " + name;
    }
}
