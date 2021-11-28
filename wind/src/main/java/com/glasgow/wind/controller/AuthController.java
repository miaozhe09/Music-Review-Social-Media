package com.glasgow.wind.controller;


import com.glasgow.wind.domain.User;
import com.glasgow.wind.service.UserService;
import com.glasgow.wind.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    UserService userService;

    @GetMapping("/register")
    public String register() {
        return "/register";
    }

    @PostMapping("/register")
    @ResponseBody
    public Object register(@RequestBody Map<String,String> map, HttpSession session){
        String username = map.get("username");
        String password = map.get("password1");

        // parameter validate TODO

        List<User> users = userService.queryByUsername(username);
        if(users.size() != 0){
            return ResponseUtil.fail("Username already exists!");
        }

        User user = new User();
        user.setUsername(username);
        user.setPassword(password); // encryption TODO
        user.setAvatar("images/defaultAvatar.jpg");

        userService.add(user);

        session.setAttribute("username", username);
        session.setAttribute("avatar",user.getAvatar());
        return ResponseUtil.ok();
    }

    @GetMapping("/login")
    public String login() {
        return "/login";
    }

    @PostMapping("/login")
    @ResponseBody
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

        String avatar = users.get(0).getAvatar();

        session.setAttribute("username", username);
        session.setAttribute("avatar", avatar);
        return ResponseUtil.ok();
    }

    @GetMapping("/logout")
    public Object logout(HttpSession session){
        session.removeAttribute("username");
        session.removeAttribute("avatar");
        return "redirect:/";
    }
}
