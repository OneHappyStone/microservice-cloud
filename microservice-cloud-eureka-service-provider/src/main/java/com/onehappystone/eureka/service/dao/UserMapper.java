package com.onehappystone.eureka.service.dao;

import com.onehappystone.eureka.service.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created by happy on 2017/7/3.
 */
@Mapper
public interface UserMapper extends BaseMapper<Long, User>{

}
