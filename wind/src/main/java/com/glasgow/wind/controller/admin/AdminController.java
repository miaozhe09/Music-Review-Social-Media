package com.glasgow.wind.controller.admin;

import com.glasgow.wind.domain.Admin;
import com.glasgow.wind.service.AdminService;
import com.glasgow.wind.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * @Author Zhe Miao Guid: 2598803M
 * @Date 2021/12/3 15:18
 * @Version 1.0
 */

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    AdminService adminService;

    @GetMapping("/login")
    public String login() {
        return "/admin/login";
    }

    @PostMapping("/login")
    @ResponseBody
    public Object login(@RequestBody Map<String,String> map, HttpSession session){
        String username = map.get("username");
        String password = map.get("password");

       List<Admin> admins = adminService.queryByUsername(username);
        if (admins.size() != 1){
            return ResponseUtil.fail("There is something wrong with the username!");
        }
        if(!admins.get(0).getPassword().equals(password)){
            return ResponseUtil.fail("The password is incorrect!");
        }

        session.setAttribute("adminId", admins.get(0).getId());
        return ResponseUtil.ok();
    }

    @GetMapping("/index")
    public String index() {
        return "/admin/index";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.removeAttribute("adminId");
        return "/admin/login";
    }
}
