package com.glasgow.wind.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author Zhe Miao Guid: 2598803M
 * @Date 2021/11/11 15:54
 * @Version 1.0
 */

@Controller
public class WebController {
    @RequestMapping("/index")
    public String index(){
        return "index";
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/register")
    public String register() {
        return "register";
    }

    @RequestMapping("/addAlbum")
    public String addAlbum(){
        return "addAlbum";
    }

    @RequestMapping("/addAlbumSuccessfully")
    public String addAlbumSuccessfully(){
        return "addAlbumSuccessfully";
    }

    @RequestMapping("/profile/{username}")
    public String profile(){
        return "profile";
    }

}
