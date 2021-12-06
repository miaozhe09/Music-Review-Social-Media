package com.glasgow.wind.controller.user;

import com.glasgow.wind.domain.User;
import com.glasgow.wind.service.UserService;
import com.glasgow.wind.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * @Author Zhe Miao Guid: 2598803M
 * @Date 2021/11/27 21:59
 * @Version 1.0
 */

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/register")
    public String register() {
        return "/user/register";
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
        user.setAvatar("http://localhost:8080/storage/fetch/defaultAvatar.jpg");

        userService.add(user);

        session.setAttribute("userId", userService.queryByUsername(username).get(0).getId());
        session.setAttribute("username", username);
        session.setAttribute("avatar",user.getAvatar());
        return ResponseUtil.ok();
    }

    @GetMapping("/login")
    public String login() {
        return "/user/login";
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

        session.setAttribute("userId", users.get(0).getId());
        session.setAttribute("username", username);
        session.setAttribute("avatar", users.get(0).getAvatar());
        return ResponseUtil.ok();
    }

    @GetMapping("/logout")
    public Object logout(HttpSession session){
        session.removeAttribute("userId");
        session.removeAttribute("username");
        session.removeAttribute("avatar");
        return "redirect:/";
    }

    @PostMapping("/update")
    @ResponseBody
    public Object update(@RequestBody User user, HttpSession session){
        int id = (int)session.getAttribute("userId");
        User user1 = userService.queryById(id);
        user1.setAvatar(user.getAvatar());
        userService.update(user1);
        session.setAttribute("avatar", user.getAvatar());

        return ResponseUtil.ok();
    }
}
