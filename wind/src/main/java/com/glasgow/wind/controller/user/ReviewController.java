package com.glasgow.wind.controller.user;

import com.glasgow.wind.domain.Review;
import com.glasgow.wind.util.ResponseUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author Zhe Miao Guid: 2598803M
 * @Date 2021/12/6 10:59
 * @Version 1.0
 */

@Controller
@RequestMapping("/review")
public class ReviewController {
    @PostMapping("/create")
    @ResponseBody
    public Object create(@RequestBody Review review){
        return ResponseUtil.ok();
    }
}
