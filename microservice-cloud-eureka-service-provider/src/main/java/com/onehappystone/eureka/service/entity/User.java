package com.onehappystone.eureka.service.entity;

import lombok.Data;

import java.util.Date;

/**
 * Created by happy on 2017/7/3.
 */
@Data
public class User {
    private Long id;
    private Integer statusFlag;
    private Date serverCreateTime;
    private Date serverUpdateTime;
    private String account;
    private String password;
    private String salt;
    private String name;
    private String email;
}
