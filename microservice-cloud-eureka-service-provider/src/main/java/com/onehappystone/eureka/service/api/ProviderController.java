package com.onehappystone.eureka.service.api;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.onehappystone.eureka.service.service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;


/**
 * Created by happy on 2017/3/4.
 * 如果服务器尚未执行任何命令来生成度量，hystrix.stream servlet将循环无限地等待度量。
 */
@RestController
@RequestMapping
public class ProviderController {
    @Autowired
    private ProviderService providerService;

    @RequestMapping("/sayHello/{name}")
    @HystrixCommand(fallbackMethod = "defaultName")
    public String sayHello(@PathVariable("name") String name){
        return providerService.sayHello(name);
    }

    public String defaultName(String name) {
        return "Hello, Everyone!";
    }
}
