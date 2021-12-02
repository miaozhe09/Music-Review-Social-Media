package com.glasgow.wind.controller;

import com.glasgow.wind.domain.Rating;
import com.glasgow.wind.service.RatingService;
import com.glasgow.wind.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author Zhe Miao Guid: 2598803M
 * @Date 2021/11/30 18:03
 * @Version 1.0
 */

@Controller
@RequestMapping("/rate")
public class RatingController {
    @Autowired
    RatingService ratingService;

    @GetMapping("/{albumId}/{userId}")
    @ResponseBody
    public Object getRatingByAlbumIdAndUserId(@PathVariable("albumId") int albumId, @PathVariable("userId") int userId, Model model){
        List<Rating> ratings = ratingService.queryByAlbumIdAndUserId(albumId, userId);
        if(ratings.size() != 1){
            return ResponseUtil.fail();
        }

        return ResponseUtil.ok(ratings.get(0).getScore());
    }

    @PostMapping("/create")
    @ResponseBody
    public Object create(@RequestBody Rating rating){
        Integer userId = rating.getUserId();
        Integer albumId = rating.getAlbumId();
        List<Rating> ratings = ratingService.queryByAlbumIdAndUserId(albumId, userId);
        if(ratings.size() != 0){
            return ResponseUtil.fail();
        }

        ratingService.add(rating);
        return ResponseUtil.ok();
    }


}
