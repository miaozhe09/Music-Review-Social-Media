package com.glasgow.wind.controller.user;

import com.glasgow.wind.domain.Album;
import com.glasgow.wind.domain.AlbumHistory;
import com.glasgow.wind.dto.AuditDTO;
import com.glasgow.wind.domain.Message;
import com.glasgow.wind.domain.Review;
import com.glasgow.wind.service.*;
import com.glasgow.wind.util.ResponseUtil;
import com.glasgow.wind.vo.AlbumReviewVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
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

    @Autowired
    MessageService messageService;

    @Autowired(required = false)
    AlbumHistoryService albumHistoryService;

    @GetMapping("/{id}")
    public String getAlbumById(@PathVariable("id") int id, Model model){
        Album album = albumService.queryById(id);
        // System.out.println(album.getTrackListing());
        String newTrackListing = album.getTrackListing().replaceAll("[\\r]","<br>");
        String newIntroduction = album.getIntroduction().replaceAll("[\\r]", "<br>");
        // System.out.println(newTrackListing);
        album.setTrackListing(newTrackListing);
        album.setIntroduction(newIntroduction);

        if(album != null){
            model.addAttribute("album", album);

            Object albumRatingCount = ratingService.getAlbumRatingCount(id);
            model.addAttribute("ratingCount",albumRatingCount);
            if((long)albumRatingCount >= 10){
                model.addAttribute("averageRating", ratingService.getAlbumAverageRating(id));
            }

            List<Review> reviewList = reviewService.getAllByAlbumId(id);
            List<AlbumReviewVO> reviewVOList = new ArrayList<>();
            for (int i = 0; i < reviewList.size(); i++) {
                Review review = reviewList.get(i);
                AlbumReviewVO albumReviewVO = new AlbumReviewVO();
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
    public Object approve(@RequestBody AuditDTO auditDTO){
        AlbumHistory albumHistory = albumHistoryService.queryById(auditDTO.getId());
        albumHistory.setStatus(1);

        // create album (if first time) ; update album (else)
        Album album = null; String content = null;
        if (StringUtils.isEmpty(albumHistory.getAlbumId())){
            album = new Album();
            albumHistory.setAlbumId(albumService.getMaxId()+1);
            album.setId(albumService.getMaxId()+1);
            album.setName(albumHistory.getName());
            album.setArtist(albumHistory.getArtist());
            album.setGenre(albumHistory.getGenre());
            album.setReleaseDate(albumHistory.getReleaseDate());
            album.setIntroduction(albumHistory.getIntroduction());
            album.setTrackListing(albumHistory.getTrackListing());
            album.setCoverUrl(albumHistory.getCoverUrl());
            albumService.add(album); // need to judege success, id may be Duplicate TODO

            content = "The album (" + albumHistory.getName() + ") you created has been approved.";
        }else{
            album = albumService.queryById(albumHistory.getAlbumId());
            album.setName(albumHistory.getName());
            album.setArtist(albumHistory.getArtist());
            album.setGenre(albumHistory.getGenre());
            album.setReleaseDate(albumHistory.getReleaseDate());
            album.setIntroduction(albumHistory.getIntroduction());
            album.setTrackListing(albumHistory.getTrackListing());
            album.setCoverUrl(albumHistory.getTrackListing());
            albumService.update(album);

            content = "The album (" + albumHistory.getName() + ") you modified has been approved.";
        }

        if(albumHistoryService.update(albumHistory) != 1){
            return ResponseUtil.fail();
        }

        int contributorId = albumHistory.getContributorId();
        int senderId = auditDTO.getAdminId();
        // send message to user
        Message message = new Message();
        message.setSenderId(senderId);
        message.setReceiverId(contributorId);
        message.setSenderType(0); // 0: admin 1: user
        message.setContent(content);
        messageService.add(message);

        return ResponseUtil.ok();
    }

    @PostMapping("/disapprove")
    @ResponseBody
    public Object disapprove(@RequestBody AuditDTO auditDTO){
        AlbumHistory albumHistory = albumHistoryService.queryById(auditDTO.getId());
        albumHistory.setStatus(2);

        // create album (if first time) ; update album (else)
        Album album = null; String content = null;
        if (StringUtils.isEmpty(albumHistory.getAlbumId())){
            content = "The album (" + albumHistory.getName() + ") you created has not been approved.";
        }else{
            content = "The album (" + albumHistory.getName() + ") you modified has not been approved.";
        }

        if(albumHistoryService.update(albumHistory) != 1){
            return ResponseUtil.fail();
        }

        int contributorId = albumHistory.getContributorId();
        int senderId = auditDTO.getAdminId();
        // send message to user
        Message message = new Message();
        message.setSenderId(senderId);
        message.setReceiverId(contributorId);
        message.setSenderType(0); // 0: admin 1: user
        message.setContent(content);
        messageService.add(message);

        return ResponseUtil.ok();
    }
}
