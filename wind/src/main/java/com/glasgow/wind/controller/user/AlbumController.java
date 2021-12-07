package com.glasgow.wind.controller.user;

import com.glasgow.wind.domain.Album;
import com.glasgow.wind.domain.Review;
import com.glasgow.wind.service.AlbumService;
import com.glasgow.wind.service.RatingService;
import com.glasgow.wind.service.ReviewService;
import com.glasgow.wind.service.UserService;
import com.glasgow.wind.util.ResponseUtil;
import com.glasgow.wind.vo.albumReviewVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

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

    @Autowired
    ReviewService reviewService;

    @Autowired
    UserService userService;

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

            List<Review> reviewList = reviewService.getAllByAlbumId(id);
            List<albumReviewVO> reviewVOList = new ArrayList<>();
            for (int i = 0; i < reviewList.size(); i++) {
                Review review = reviewList.get(i);
                albumReviewVO albumReviewVO = new albumReviewVO();
                albumReviewVO.setUsername(userService.queryById(review.getUserId()).getUsername());
                albumReviewVO.setContent(review.getContent());
                albumReviewVO.setLikeCount(review.getLikeCount());
                albumReviewVO.setReviewId(review.getId());
                String format = new SimpleDateFormat("yyyy-MM-dd").format(review.getUpdateTime());
                albumReviewVO.setUpdateTime(format);

                reviewVOList.add(albumReviewVO);
            }

            model.addAttribute("reviewVOListSize", reviewVOList.size());
            model.addAttribute("reviewVOList", reviewVOList);
            return "/user/album";
        }

        return "redirect:/"; // if the album does not exist
    }

    @GetMapping("/create")
    public String addAlbum(){
        return "/user/addAlbum";
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
        return "/user/addReview";
    }

    @PostMapping("/approve")
    @ResponseBody
    public Object approve(@RequestBody Album album){
        Album album1 = albumService.queryById(album.getId());
        album1.setAlbumStatus(1);

        if(albumService.update(album1) != 1){
            return ResponseUtil.fail();
        }

        return ResponseUtil.ok();
    }

    @PostMapping("/disapprove")
    @ResponseBody
    public Object disapprove(@RequestBody Album album){
        Album album1 = albumService.queryById(album.getId());
        album1.setAlbumStatus(2);

        if(albumService.update(album1) != 1){
            return ResponseUtil.fail();
        }

        return ResponseUtil.ok();
    }
}
