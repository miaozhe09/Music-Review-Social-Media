package com.glasgow.wind.service;


import com.glasgow.wind.dao.UserMapper;
import com.glasgow.wind.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author Zhe Miao Guid: 2598803M
 * @Date 2021/11/3 16:50
 * @Version 1.0
 */

@Service
public class UserService {
    @Autowired(required=false)
    UserMapper userMapper;

    public void add(User user) {
        userMapper.insertSelective(user);
    }

}
