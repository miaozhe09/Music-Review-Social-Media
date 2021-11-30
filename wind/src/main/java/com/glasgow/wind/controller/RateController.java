package com.glasgow.wind.controller;

import com.glasgow.wind.util.ResponseUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @Author Zhe Miao Guid: 2598803M
 * @Date 2021/11/30 18:03
 * @Version 1.0
 */

@Controller
@RequestMapping("/rate")
public class RateController {
    @GetMapping("/{albumId}/{userId}")
    @ResponseBody
    public Object getRateByAlbumIdAndUserId(@PathVariable("albumId") int albumId, @PathVariable("userId") int userId, Model model){
        return ResponseUtil.ok(1);
    }

    @PostMapping("/create")
    @ResponseBody
    public Object create(@RequestBody Map<String,String> map){
        return ResponseUtil.ok();
    }
}
