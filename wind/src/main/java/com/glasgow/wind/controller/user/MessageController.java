package com.glasgow.wind.controller.user;

import com.glasgow.wind.domain.Message;
import com.glasgow.wind.service.MessageService;
import com.glasgow.wind.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author Zhe Miao Guid: 2598803M
 * @Date 2021/12/8 20:44
 * @Version 1.0
 */

@Controller
@RequestMapping("/message")
public class MessageController {
    @Autowired
    MessageService messageService;

    @PostMapping("/delete")
    @ResponseBody
    public Object delete(@RequestBody Message message){
       if(messageService.deleteById(message.getId()) != 1){
            return ResponseUtil.fail();
        }
        return ResponseUtil.ok();
    }
}
