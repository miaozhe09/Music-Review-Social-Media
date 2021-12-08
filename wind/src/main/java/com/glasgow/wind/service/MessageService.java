package com.glasgow.wind.service;

import com.glasgow.wind.dao.MessageMapper;
import com.glasgow.wind.domain.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @Author Zhe Miao Guid: 2598803M
 * @Date 2021/12/8 16:38
 * @Version 1.0
 */

@Service
public class MessageService {
    @Autowired(required=false)
    MessageMapper messageMapper;

    public void add(Message message){
        message.setAddTime(new Date());
        messageMapper.insertSelective(message);
    }
}
