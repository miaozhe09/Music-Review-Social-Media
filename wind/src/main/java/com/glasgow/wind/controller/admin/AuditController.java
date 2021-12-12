package com.glasgow.wind.controller.admin;

import com.glasgow.wind.domain.AlbumHistory;
import com.glasgow.wind.service.AlbumHistoryService;
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

    @Autowired
    AlbumHistoryService albumHistoryService;

    @GetMapping
    public String audit(Model model) {
        List<AlbumHistory> albumHistoryList = albumHistoryService.getUnaudited();
        for (int i = 0; i < albumHistoryList.size(); i++) {
            AlbumHistory albumHistory = albumHistoryList.get(i);
            String newTrackListing = albumHistory.getTrackListing().replaceAll("[\\r]","<br>");
            String newIntroduction = albumHistory.getIntroduction().replaceAll("[\\r]", "<br>");
            albumHistory.setTrackListing(newTrackListing);
            albumHistory.setIntroduction(newIntroduction);
        }

        model.addAttribute("albumList", albumHistoryList);
        model.addAttribute("count", albumHistoryList.size());
        return "/admin/audit";
    }
}
