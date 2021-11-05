package com.glasgow.wind.controller;


import com.glasgow.wind.domain.User;
import com.glasgow.wind.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
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

        return "register success";
    }


    @PostMapping("login")
    public Object login(@RequestBody String body) {
        return "";
    }

}
