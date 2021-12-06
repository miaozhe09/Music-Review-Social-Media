package com.glasgow.wind.service;


import com.glasgow.wind.dao.UserMapper;
import com.glasgow.wind.domain.User;
import com.glasgow.wind.domain.UserExample;
import org.omg.CORBA.UserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<User> queryByUsername(String name){
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();

        criteria.andUsernameEqualTo(name);

        return userMapper.selectByExample(example);
    }

    public User queryById(int id){
        return userMapper.selectByPrimaryKey(id);
    }

}
