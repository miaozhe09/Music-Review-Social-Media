package com.glasgow.wind.controller.user;

import com.glasgow.wind.domain.Album;
import com.glasgow.wind.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author Zhe Miao Guid: 2598803M
 * @Date 2021/11/20 16:01
 * @Version 1.0
 */

@Controller
@RequestMapping("/search")
public class SearchController {
    @Autowired
    AlbumService albumService;

    @GetMapping
    public String search() {
        return "/user/search";
    }

    @GetMapping("/all")
    public String searchResult(@RequestParam("keyword")String keyword, Model model){
        List<Album> albums = albumService.queryApprovedByKeyword(keyword);
        model.addAttribute("albumList", albums);

        return "/user/searchResult";
    }
}
