package com.glasgow.wind.controller;

import com.glasgow.wind.domain.Album;
import com.glasgow.wind.service.AlbumService;
import com.glasgow.wind.service.RatingService;
import com.glasgow.wind.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * @Author Zhe Miao Guid: 2598803M
 * @Date 2021/11/20 21:46
 * @Version 1.0
 */

@Controller
@RequestMapping("/album")
public class AlbumController {
    @Autowired
    AlbumService albumService;

    @Autowired
    RatingService ratingService;

    @GetMapping("/{id}")
    public String getAlbumById(@PathVariable("id") int id, Model model){
        Album album = albumService.queryById(id);
        if(album != null){
            model.addAttribute("album", album);
            Object albumRatingCount = ratingService.getAlbumRatingCount(id);
            model.addAttribute("ratingCount",albumRatingCount);
            if((long)albumRatingCount >= 10){
                model.addAttribute("averageRating", ratingService.getAlbumAverageRating(id));
            }

            return "/album";
        }

        return "redirect:/"; // if the album does not exist
    }

    @GetMapping("/create")
    public String addAlbum(){
        return "/addAlbum";
    }

    @PostMapping("/create")
    @ResponseBody
    public Object create(@RequestBody Album album){
        albumService.add(album);
        return ResponseUtil.ok();
    }

    @GetMapping("/{id}/addReview")
    public String addReview(@PathVariable("id") int id, Model model){
        Album album = albumService.queryById(id);
        model.addAttribute("album", album);
        return "/addReview";
    }
}
