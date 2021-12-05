package com.glasgow.wind.controller.user;

import com.glasgow.wind.domain.Album;
import com.glasgow.wind.domain.Rating;
import com.glasgow.wind.service.AlbumService;
import com.glasgow.wind.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Zhe Miao Guid: 2598803M
 * @Date 2021/11/11 15:54
 * @Version 1.0
 */

@Controller
public class WebController {
    @Autowired
    RatingService ratingService;

    @Autowired
    AlbumService albumService;

    @GetMapping("/")
    public String index(Model model){
        List<Integer> albumIdList = ratingService.queryRecommendAlbumId(albumService.getAlbumIdsWithinOneMonth());
        List<Album> albumList = new ArrayList<>();
        for (int i = 0; i < albumIdList.size(); i++) {
            albumList.add(albumService.queryById(albumIdList.get(i)));
        }

        setAttribute(albumList, model);
        return "/user/index";
    }

    /*@RequestMapping("/profile/{username}")
    public String profile(){
        return "/profile";
    }*/

    @RequestMapping("/albumToBeReviewed")
    public String albumToBeReviewd(){
        return "/user/albumToBeReviewed";
    }

    @RequestMapping("/newRelease")
    public String newRelease(){
        return "/user/newRelease";
    }

    @RequestMapping("/discover")
    public String discover(){
        return "/user/discover";
    }

    @RequestMapping("/charts")
    public String charts(){
        return "/user/charts";
    }

    @RequestMapping("/review")
    public String review(){
        return "/user/review";
    }

    public void setAttribute(List<Album> albumList, Model model){
        model.addAttribute("c1", albumList.get(0));
        model.addAttribute("c2", albumList.get(1));
        model.addAttribute("c3", albumList.get(2));
        model.addAttribute("c4", albumList.get(3));
        model.addAttribute("n1", albumList.get(4));
        model.addAttribute("n2", albumList.get(5));
        model.addAttribute("n3", albumList.get(6));
        model.addAttribute("n4", albumList.get(7));
        model.addAttribute("n5", albumList.get(8));
        model.addAttribute("n6", albumList.get(9));
        model.addAttribute("n7", albumList.get(10));
        model.addAttribute("n8", albumList.get(11));
    }

}
