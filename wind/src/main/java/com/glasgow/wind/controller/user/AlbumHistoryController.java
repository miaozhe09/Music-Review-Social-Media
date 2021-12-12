package com.glasgow.wind.controller.user;

import com.glasgow.wind.domain.AlbumHistory;
import com.glasgow.wind.service.AlbumHistoryService;
import com.glasgow.wind.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author Zhe Miao Guid: 2598803M
 * @Date 2021/12/12 10:38
 * @Version 1.0
 */
@Controller
@RequestMapping("/albumHistory")
public class AlbumHistoryController {
    @Autowired
    AlbumHistoryService albumHistoryService;

    @PostMapping("/create")
    @ResponseBody
    public Object create(@RequestBody AlbumHistory albumHistory){
        albumHistoryService.add(albumHistory);
        return ResponseUtil.ok();
    }
}
