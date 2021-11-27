package com.glasgow.wind.controller;


import com.glasgow.wind.domain.User;
import com.glasgow.wind.service.UserService;
import com.glasgow.wind.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    UserService userService;

    @PostMapping("/register")
    public Object register(@RequestBody Map<String,String> map, HttpSession session){
        String username = map.get("username");
        String password = map.get("password1");

        // parameter validate TODO

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);

        userService.add(user);

        session.setAttribute("username", username);
        session.setAttribute("avatar","c1.jpg");
        return ResponseUtil.ok();
    }

    @PostMapping("/login")
    public Object login(@RequestBody Map<String,String> map, HttpSession session){
        // System.out.println(map);
        String username = map.get("username");
        String password = map.get("password");

        List<User> users = userService.queryByUsername(username);
        if (users.size() != 1){
            return ResponseUtil.fail("There is something wrong with the username!");
        }
        if(!users.get(0).getPassword().equals(password)){
            return ResponseUtil.fail("The password is incorrect!");
        }

        session.setAttribute("username", username);
        session.setAttribute("avatar","c1.jpg");
        return ResponseUtil.ok();
    }




}
