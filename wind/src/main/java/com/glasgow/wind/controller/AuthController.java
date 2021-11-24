package com.glasgow.wind.controller;


import com.glasgow.wind.domain.User;
import com.glasgow.wind.service.UserService;
import com.glasgow.wind.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    UserService userService;



    @PostMapping("/register")
    public Object register(@RequestBody Map<String,String> map){
        String username = map.get("username");
        String password = map.get("password");

        // parameter validate TODO

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);

        userService.add(user);

        return ResponseUtil.ok();
    }




}
