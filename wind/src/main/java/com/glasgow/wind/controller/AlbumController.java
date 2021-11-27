package com.glasgow.wind.controller;

import com.glasgow.wind.domain.Album;
import com.glasgow.wind.service.AlbumService;
import com.glasgow.wind.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * @Author Zhe Miao Guid: 2598803M
 * @Date 2021/11/20 21:46
 * @Version 1.0
 */

@RestController
@RequestMapping("/album")
public class AlbumController {
    @Autowired
    AlbumService albumService;

    @GetMapping("/{id}") // TODO
    public String getAlbumById(@PathVariable("id") Integer id, Model model){
        return "album";
    }

    @PostMapping("/create")
    public Object create(@RequestBody Album album){
        albumService.add(album);
        return ResponseUtil.ok();
    }

}
