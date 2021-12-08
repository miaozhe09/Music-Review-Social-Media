package com.glasgow.wind.service;

import com.glasgow.wind.dao.AdminMapper;
import com.glasgow.wind.domain.Admin;
import com.glasgow.wind.domain.AdminExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author Zhe Miao Guid: 2598803M
 * @Date 2021/12/3 15:27
 * @Version 1.0
 */

@Service
public class AdminService {
    @Autowired(required=false)
    AdminMapper adminMapper;

    public List<Admin> queryByUsername(String name){
        AdminExample example = new AdminExample();
        AdminExample.Criteria criteria = example.createCriteria();

        criteria.andUsernameEqualTo(name);

        return adminMapper.selectByExample(example);
    }

    public Admin queryById(int id){
        return adminMapper.selectByPrimaryKey(id);
    }
}
