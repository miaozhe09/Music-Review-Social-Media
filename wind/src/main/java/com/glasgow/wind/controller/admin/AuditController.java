package com.glasgow.wind.controller.admin;

import com.glasgow.wind.domain.Album;
import com.glasgow.wind.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @Author Zhe Miao Guid: 2598803M
 * @Date 2021/12/3 18:00
 * @Version 1.0
 */

@Controller
@RequestMapping("/audit")
public class AuditController {
    @Autowired
    AlbumService albumService;

    @GetMapping
    public String audit(Model model) {
        List<Album> albums = albumService.getUnauditedAlbums();
        for (int i = 0; i < albums.size(); i++) {
            Album album = albums.get(i);
            String newTrackListing = album.getTrackListing().replaceAll("[\\r]","<br>");
            String newIntroduction = album.getIntroduction().replaceAll("[\\r]", "<br>");
            album.setTrackListing(newTrackListing);
            album.setIntroduction(newIntroduction);
        }

        model.addAttribute("albumList", albums);
        model.addAttribute("count", albums.size());
        return "/admin/audit";
    }
}
